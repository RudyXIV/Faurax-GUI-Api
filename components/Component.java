package gq.rxdy.ancient.gui.click.components;

public abstract class Component {

	public abstract void addComponent(Component component);
	
	public abstract void drawComponent(int x, int y);
	
	public abstract void mouseClick(int x, int y, int type);
	
	public abstract void mouseRelease(int x, int y, int type);
	
	public abstract boolean isHovering(int posX, int posY);
}
