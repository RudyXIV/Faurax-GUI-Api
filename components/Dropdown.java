package gq.rxdy.ancient.gui.click.components;

import gq.rxdy.ancient.gui.click.MainUI;
import gq.rxdy.ancient.gui.click.theme.Theme;

import java.util.ArrayList;

public class Dropdown extends Component{

	private String name;
	private float posX;
	private float posY;
	private boolean isOpen;
	public Panel panel;
	public ArrayList<Component> components = new ArrayList<Component>();

	public Dropdown(String name, float posX, float posY, Panel panel)
	{
		this.setPosX(posX);
		this.setPosY(posY);
		this.setName(name);
		this.panel = panel;

		for(Theme theme : MainUI.getThemes().themes)
		{
			if(theme.isActive())
			{
				theme.invokeDropdownConstructor(this, panel);
			}
		}
	}

	@Override
	public void addComponent(Component component) {
		if(component instanceof DropdownButton)
		{
			((DropdownButton) component).dropdown = this;
		}
		this.components.add(component);
	}

	@Override
	public void drawComponent(int x, int y) {
        MainUI.getThemes().themes.stream().filter(v -> v.isActive()).forEachOrdered(b -> b.invokeDropdownDraw(this, panel, x , y));
		this.components.stream().forEach(a -> a.drawComponent(x, y));
	}

	@Override
	public void mouseClick(int x, int y, int type) {
		for(Theme theme : MainUI.getThemes().themes)
		{
			if(theme.isActive())
			{
				theme.invokeDropdownMouseClick(this, panel, x, y, type);
			}
		}
		for(Component component : this.components)
		{
			component.mouseClick(x, y, type);
		}
	}

	@Override
	public void mouseRelease(int x, int y, int type) {
		for(Theme theme : MainUI.getThemes().themes)
		{
			if(theme.isActive())
			{
				theme.invokeDropdownMouseMovedOrUp(this, panel, x, y, type);
			}
		}
		for(Component component : this.components)
		{
			component.mouseRelease(x, y, type);
		}
	}

	@Override
	public boolean isHovering(int posX, int posY) {
		return false;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

}
