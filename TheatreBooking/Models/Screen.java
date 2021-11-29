import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

enum ScreenType{
	
}


//Later to Put in Utility Class




public class Screen {
	int no;
	private List<Seat> seats;
	
	public Screen(int no) 
	{
		this.no = no;
		seats = new ArrayList<Seat>(); 
	}
	
	public void addSeats(Seat s)
	{
		seats.add(s);
	}
	
	public  List<Integer> getAvailableSeats()
	{
		List<Integer> availableSeat = new ArrayList<Integer>();
		for(Seat ss : seats)
		{
			if(ss.status==SEAT_STATUS.VACANT)
				availableSeat.add(ss.SeatNo);
			else if((ss.status == SEAT_STATUS.LOCKED) && (System.currentTimeMillis()-ss.blockedTime)>100000)
			{
				ss.status = SEAT_STATUS.VACANT;
				ss.blockedTime = 0;
				availableSeat.add(ss.SeatNo);
			}
		}
		return availableSeat;
	}
	
	public Seat getSeat(int seatId)
	{
		Seat st = null;
		for(Seat ss: seats)
		{
			if(ss.SeatNo == seatId)
			{
				st = ss;
				break;
			}
				
		}
		
		if(st== null)
		{
			System.out.println("Invalid SeatId");
		}
		return st;
	}
	
	public synchronized boolean markInProgress(int seatNo)
	{
		
		Seat st = this.getSeat(seatNo);
		if(st != null)
		{
			st.status = SEAT_STATUS.LOCKED;
			st.blockedTime = System.currentTimeMillis();;
			return true;
		}
		return false;
			
	}
	
	public synchronized boolean bookTicket(int seatNo)
	{
		Seat st = this.getSeat(seatNo);
		if(st != null)
		{
			st.status = SEAT_STATUS.OCCUPIED;
			return true;
		}
		return false;
	}
	
	
}
