import java.util.ArrayList;
import java.util.List;

//This is Singelton Class Used as Databases
public class MemoryDataBases {
	private Theatre tht;
	private ArrayList<Movie> mv;
	private List<Show> runningShws;
	private static MemoryDataBases db = null;
	
	private MemoryDataBases() {
		
		mv = new ArrayList<>();
		runningShws = new ArrayList<>();
	}
	
	public static MemoryDataBases getInstance()
	{
		if(db == null)
		{
			db = new MemoryDataBases();
		}
		return db;
	}
	
	
	public Theatre getTheatre()
	{
		return tht;
	}
	
	public void setTheatre(Theatre tht)
	{
		this.tht = tht;
	}
	
	public ArrayList<Movie> getMovies()
	{
		return mv;
	}
	
	public List<Show> getShows()
	{
		return runningShws;
	}
	
}
