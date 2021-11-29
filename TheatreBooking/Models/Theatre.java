import java.util.*;
public class Theatre {
	
	//This Can Be Singleton 
	
	String name;
	List<Screen> screens;
	public Theatre(String name) 
	{
		this.name = name;
		screens = new ArrayList<>();
	}
	
	public void addScreen(Screen scr)
	{
		screens.add(scr);
	}
	
	public Screen getScreen(int ScreenId)
	{
		for(Screen srr: screens)
		{
			if(srr.no == ScreenId)
			{
				return srr;
			}
		}
		return null;
	}
	
}
