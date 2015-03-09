package gq.rxdy.ancient.gui.click.components;

import gq.rxdy.ancient.gui.click.MainUI;
import gq.rxdy.ancient.gui.click.theme.Theme;

import java.util.ArrayList;

public class Panel extends Component{

	public String name;
	public int x;
	public int y;
	public int lastX;
	public int lastY;
	public boolean isDragging;
	public boolean isOpen;
	public boolean isExtended;
	public boolean isPinned;
	public float dragX;
	public float dragY;

	public ArrayList<Component> components = new ArrayList<Component>();


	public Panel(String name, int x, int y)
	{
		this.setName(name);
		this.setX(x);
		this.setY(y);

		for(Theme theme : MainUI.getThemes().themes)
		{
			if(theme.isActive())
			{
				theme.invokePanelConstructor(this, name, x, y);
			}
		}
	}

	@Override
	public void addComponent(Component component) {

		if (component instanceof Button)
		{
			((Button) component).panel = this;
		}
		if (component instanceof Slider) 
		{
			((Slider) component).panel = this;
		}
		if(component instanceof Dropdown)
		{
			((Dropdown) component).panel = this;
		}
		this.components.add(component);
	}

	@Override
	public void drawComponent(int x, int y) {
		for(Theme theme : MainUI.getThemes().themes)
		{
			if(theme.isActive())
			{
				theme.invokeDraw(this, x, y);
			}
		}

		if(this.isExtended())
		{
			for(Component component : this.components)
			{
				component.drawComponent(x, y);
			}
		}
	}

	@Override
	public void mouseClick(int x, int y, int type) {
		for(Theme theme : MainUI.getThemes().themes)
		{
			if(theme.isActive())
			{
				theme.invokeMouseClicked(this, x, y, type);
			}
		}
		if(this.isExtended())
		{
			for(Component component : this.components)
			{
				component.mouseClick(x, y, type);
			}
		}
	}

	@Override
	public void mouseRelease(int x, int y, int type) {
		for(Theme theme : MainUI.getThemes().themes)
		{
			if(theme.isActive())
			{
				theme.invokeMouseMovedOrUp(this, x, y, type);
			}
		}
		if(this.isExtended())
		{
			for(Component component : this.components)
			{
				component.mouseRelease(x, y, type);
			}
		}
	}

	@Override
	public boolean isHovering(int posX, int posY) {
		// TODO Auto-generated method stub
		return false;
	}

	public float getDragX()
	{
		return this.dragX;
	}

	public void setDragX(float dragX)
	{
		this.dragX = dragX;
	}

	public float getDragY()
	{
		return this.dragY;
	}

	public void setDragY(float dragY)
	{
		this.dragY = dragY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLastX() {
		return lastX;
	}

	public void setLastX(int lastX) {
		this.lastX = lastX;
	}

	public int getLastY() {
		return lastY;
	}

	public void setLastY(int lastY) {
		this.lastY = lastY;
	}

	public boolean isDragging() {
		return isDragging;
	}

	public void setDragging(boolean isDragging) {
		this.isDragging = isDragging;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public boolean isExtended() {
		return isExtended;
	}

	public void setExtended(boolean isExtended) {
		this.isExtended = isExtended;
	}

	public boolean isPinned() {
		return isPinned;
	}

	public void setPinned(boolean isPinned) {
		this.isPinned = isPinned;
	}

}
