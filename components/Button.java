package gq.rxdy.ancient.gui.click.components;


import gq.rxdy.ancient.gui.click.MainUI;
import gq.rxdy.ancient.gui.click.theme.Theme;

public class Button extends Component{

	private float posX;
	private float posY;
	private String name;
	private boolean isHovering;
	private boolean isEnabled;
	private boolean isOpen;
	public Panel panel;

	public Button(Panel panel, float posX, float posY, String name)
	{
		this.setPosX(posX);
		this.setPosY(posY);
		this.setName(name);
		this.panel = panel;

		for(Theme theme : MainUI.getThemes().themes)
		{
			if(theme.isActive())
			{
				theme.invokeButtonConstructor(this, panel);
			}
		}

	}

	@Override
	public void drawComponent(int x, int y) {
		for(Theme theme : MainUI.getThemes().themes)
		{
			if(theme.isActive())
			{
				theme.invokeButtonDraw(this, this.panel, x, y);
			}
		}
	}

	@Override
	public void mouseClick(int x, int y, int type) {
        MainUI.getThemes().themes.stream().filter(q -> q.isActive()).filter(f -> MainUI.panels.get(0)==this.panel).forEach(t -> t.invokeButtonMouseClick(this, this.panel, x, y, type));
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

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	@Override
	public void addComponent(Component component) {
		
	}

}
