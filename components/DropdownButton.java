package gq.rxdy.ancient.gui.click.components;

import gq.rxdy.ancient.gui.click.MainUI;
import gq.rxdy.ancient.gui.click.theme.Theme;

public class DropdownButton extends Component{

	private float posX;
	private float posY;
	private String name;
	private boolean isHovering;
	private boolean isEnabled;
	public Panel panel;
	public Dropdown dropdown;
	
	public DropdownButton(Panel panel, Dropdown dropdown, float posX, float posY, String name)
	{
		this.setPosX(posX);
		this.setPosY(posY);
		this.setName(name);
		this.panel = panel;

		for(Theme theme : MainUI.getThemes().themes)
		{
			if(theme.isActive())
			{
				theme.invokeDropdownButtonConstructor(this.dropdown, this, panel);
			}
		}

	}

	@Override
	public void drawComponent(int x, int y) {
		for(Theme theme : MainUI.getThemes().themes)
		{
			if(theme.isActive())
			{
				theme.invokeDropdownButtonDraw(this.dropdown, this, panel, x, y);
			}
		}
	}

	@Override
	public void mouseClick(int x, int y, int type) {
		for(Theme theme : MainUI.getThemes().themes)
		{
			if(theme.isActive())
			{
				theme.invokeDropdownButtonMouseClick(this.dropdown, this, this.panel, x, y, type);
			}
		}
	}

	@Override
	public void mouseRelease(int x, int y, int type) {

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHovering() {
		return isHovering;
	}

	public void setHovering(boolean isHovering) {
		this.isHovering = isHovering;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	@Override
	public void addComponent(Component component) {

	}

}
