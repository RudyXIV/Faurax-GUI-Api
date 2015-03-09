package gq.rxdy.ancient.gui.click.theme;

import gq.rxdy.ancient.gui.click.MainUI;
import gq.rxdy.ancient.gui.click.components.*;

public abstract class Theme {

	public static String name;
	public boolean active;

	public abstract void invokeMainConstructor(MainUI UI);
	
	public abstract void invokeDraw(Panel panel, int x, int y);

	public abstract void invokeMouseClicked(Panel panel, int x, int y, int type);

	public abstract void invokeMouseMovedOrUp(Panel panel, int x, int y, int type);

	public abstract void invokePanelConstructor(Panel panel, String name, int x, int y);

	public abstract void invokeButtonConstructor(Button button, Panel panel);
	
	public abstract void invokeButtonDraw(Button button, Panel panel, float x, float y);
	
	public abstract void invokeButtonMouseClick(Button button, Panel panel, float x, float y, int type);
	
	public abstract void invokeSliderConstructor(Slider slider, Panel panel);
	
	public abstract void invokeSliderDraw(Slider slider, Panel panel, float x, float y);
	
	public abstract void invokeSliderMouseClick(Slider slider, Panel panel, float x, float y);
	
	public abstract void invokeSliderMouseMovedOrUp(Slider slider, Panel panel, float x, float y, int type);
	
	public abstract void invokeDropdownConstructor(Dropdown dropdown, Panel panel);
	
	public abstract void invokeDropdownDraw(Dropdown dropdown, Panel panel, float x, float y);

	public abstract void invokeDropdownMouseClick(Dropdown dropdown, Panel panel, float x, float y, int type);

	public abstract void invokeDropdownMouseMovedOrUp(Dropdown dropdown, Panel panel, float x, float y, int type);
	
	public abstract void invokeDropdownButtonConstructor(Dropdown dropdown, DropdownButton button, Panel panel);
	
	public abstract void invokeDropdownButtonDraw(Dropdown dropdown, DropdownButton button, Panel panel, float x, float y);
	
	public abstract void invokeDropdownButtonMouseClick(Dropdown dropdown, DropdownButton button, Panel panel, float x, float y, int type);
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
