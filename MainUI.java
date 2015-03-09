package gq.rxdy.ancient.gui.click;

import gq.rxdy.ancient.gui.click.components.Panel;
import gq.rxdy.ancient.gui.click.theme.Theme;
import gq.rxdy.ancient.gui.click.theme.ThemeManager;
import net.minecraft.client.gui.GuiScreen;

import java.util.ArrayList;


public class MainUI extends GuiScreen {

	public static ThemeManager themes = new ThemeManager();
	public static ArrayList<Panel> panels = new ArrayList<Panel>();

	public MainUI()
	{
		for(Theme theme : this.getThemes().themes)
		{
			if(theme.isActive())
			{
				theme.invokeMainConstructor(this);
			}
		}
	}

	@Override
	public void drawScreen(int x, int y, float ticks)
	{
		this.drawDefaultBackground();

		for(Panel panel : this.panels)
		{
			panel.drawComponent(x, y);
		}
		super.drawScreen(x, y, ticks);
	}

	@Override
	public void mouseClicked(int x, int y, int type)
	{
		try{

			for(Panel panel : this.panels)
			{
				panel.mouseClick(x, y, type);
			}
			super.mouseClicked(x, y, type);
		}catch(Exception e)
		{

		}
	}

	@Override
	public void mouseClickMove(int x, int y, int type, long time)
	{
		for(Panel panel : this.panels)
		{
			panel.mouseRelease(x, y, type);
		}
        super.mouseClickMove(x, y, type, time);
	}

	public static void getTopPanel(Panel panel)
	{
		if(panels.contains(panel))
		{
			panels.remove(panel);
		}
		panels.add(panel);
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return true;
	}

	public static ThemeManager getThemes()
	{
		if(themes == null)
		{
			themes = new ThemeManager();
		}
		return themes;
	}


}
