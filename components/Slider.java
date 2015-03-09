package gq.rxdy.ancient.gui.click.components;

import gq.rxdy.ancient.gui.click.MainUI;
import gq.rxdy.ancient.gui.click.theme.Theme;

public class Slider extends Component{

	private float posX;
	private float posY;
	private String name;
	private boolean isHovering;
	private float floatValue;
	private int intValue;
	public Panel panel;
	public float dragX;
	public float dragY;
	public float lastX;
	public float lastY;
	public boolean isDragging;

	public Slider(String name, Panel panel, float posX, float posY, float value)
	{
		this.setName(name);
		this.setPosX(posX);
		this.setPosY(posY);
		this.setFloatValue(value);
		this.panel = panel;

		for(Theme theme : MainUI.themes.themes)
		{
			if(theme.isActive())
			{
				theme.invokeSliderConstructor(this, panel);
			}
		}
	}

	public Slider(String name, Panel panel, float posX, float posY, int value)
	{
		this.setName(name);
		this.setPosX(posX);
		this.setPosY(posY);
		this.setIntValue(value);
		this.panel = panel;

		for(Theme theme : MainUI.themes.themes)
		{
			if(theme.isActive())
			{
				theme.invokeSliderConstructor(this, panel);
			}
		}
	}
	
	@Override
	public void drawComponent(int x, int y) {
		for(Theme theme : MainUI.themes.themes)
		{
			if(theme.isActive())
			{
				theme.invokeSliderDraw(this, panel, x, y);
			}
		}
	}

	@Override
	public void mouseClick(int x, int y, int type) {
		for(Theme theme : MainUI.themes.themes)
		{
			if(theme.isActive())
			{
				theme.invokeSliderMouseClick(this, panel, x, y);
			}
		}
	}

	@Override
	public void mouseRelease(int x, int y, int type) {

		for(Theme theme : MainUI.themes.themes)
		{
			if(theme.isActive())
			{
				theme.invokeSliderMouseMovedOrUp(this, panel, x, y, type);
			}
		}
	}
	
	@Override
	public void addComponent(Component component) {
		
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

	public float getFloatValue() {
		return floatValue;
	}

	public void setFloatValue(float floatValue) {
		this.floatValue = floatValue;
	}

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public boolean isHovering(int posX, int posY) {
		return false;
	}

}
