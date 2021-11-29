import java.util.ArrayList;
import java.util.List;

public class BookingService {
	
	public BookingService() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized List<Integer> getAvailableTicket(int showId)
	{
		Show sh = ShowService.getShow(showId);
		return sh.screen.getAvailableSeats();
	}
	
	public void blockTicket(ArrayList<Integer> seatNo, int showId)
	{
		Show sh = ShowService.getShow(showId);
		for(Integer stNo:seatNo)
		{
			sh.screen.markInProgress(stNo);
		}
		
	}
	
	public void bookSeats(ArrayList<Integer> seatNo, int showId)
	{
		Show sh = ShowService.getShow(showId);
		for(Integer stNo:seatNo)
		{
			sh.screen.bookTicket(stNo);
		}
	}
	
	//BookSeats
	
	
}
