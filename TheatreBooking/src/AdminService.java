import java.util.*;
public class AdminService {
	 
	Theatre tht;
	
	public void  initTheatre()
	{
		MemoryDataBases mb  = MemoryDataBases.getInstance();
		this.tht = mb.getTheatre();
	}
	
	public void createTheatre(int noOfScreen)
	{
		tht = new Theatre("CinePolis");
		for(int i=0;i<noOfScreen;i++)
		{
			tht.addScreen(createScreen(i));
		}
		
	}
	
	public void addSeats(int ScreenId, int noOfrow, int noOfColm)
	{
		Screen scr = tht.getScreen(ScreenId);
		if(scr==null)
		{
			System.out.println("Invalin Screen");
		}
		else
		{
			int no = 0;
			for(int i=0;i<noOfrow;i++)
			{
				for(int j=0;j<noOfColm;j++)
				{
					//Later add SeatType and Seat
					scr.addSeats(new Seat(no, noOfrow, noOfColm));
					no++;
				}
			}
		}
	}
	
	
	public Screen createScreen(int screenNo)
	{
		
		//Check if ScreenId already Exist
		Screen scr = new Screen(screenNo);
		return scr;
	}
	

}
