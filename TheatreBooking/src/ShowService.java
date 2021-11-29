import java.util.ArrayList;
import java.util.List;

public class ShowService {
	Theatre tht;
	ArrayList<Movie> mv;
	static List<Show> runningShws;
	
	public ShowService(Theatre tht) 
	{
		this.tht = tht;
		mv = new ArrayList<Movie>();
		runningShws = new ArrayList<>();
		
	}
	
	public void CreateMovie(String Mname, long duration, int id)
	{
		//Movie Name Should Unique
		mv.add(new Movie(Mname, duration, id));
	}
	
	
	public Movie getMovie(int movId)
	{
		Movie ret= null;
		for(Movie m: mv)
		{
			if(m.Id == movId)
			{
				ret = m;
				break;
			}
		}
		return ret;
	}
	
	//String UID, long startTime, long endTime, Movie movie, Screen screen
	public void createShow(int movieId, int screenId, long startingTime, long endTime, int showId )
	{
		//Screen Should not be already Occupied
		Screen src = tht.getScreen(screenId);
		Movie mv=  this.getMovie(movieId);
		if(mv==null || src == null)
		{
			System.out.println("Invalid Movie or Screen");
		}
		Show ss = new Show(showId, startingTime, endTime, mv, src);
		runningShws.add(ss);
		
	}
	
	public synchronized boolean removeShow(int shId)
	{
	
		int indx = -1;
		boolean isFound = false;
		for(Show sh: runningShws)
		{
			indx++;
			if(sh.UID == shId)
			{
				isFound = true;
				break;
			}
		}
		if(isFound)
		{
			runningShws.remove(indx);
			return true;
		}
		return false;
	}
	
	public List<Show> getRunningShows()
	{
		return this.runningShws;
	}
	
	public static Show getShow(int ShowId)
	{
		Show ret = null;
		for(Show sh:runningShws)
		{
			if(sh.UID == ShowId)
			{
				ret  = sh;
				break;
			}
		}
		return ret;
	}
	
}
