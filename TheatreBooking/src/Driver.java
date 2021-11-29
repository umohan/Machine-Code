import java.io.*;
import java.util.*;
public class Driver {
	public static void main(String[]args)throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        //Steps :- 
		AdminService admn = new AdminService();
		admn.initTheatre();
		admn.createTheatre(5);
		admn.addSeats(0, 5, 5);
		admn.addSeats(1, 10, 10);
		admn.addSeats(2, 15, 15);
		admn.addSeats(3, 20, 20);
		admn.addSeats(4, 17, 19);
		
		//Screen ID 0,1,2,3,4
		ShowService shw = new ShowService(admn.tht);
		shw.CreateMovie("ZNMD", 120*60, 0);
		shw.CreateMovie("Fukrey", 150*60, 1);
		shw.CreateMovie("TWM", 112*60, 2);
		shw.CreateMovie("TWM2", 132*60, 5);
		
		//Movie ID 0,1,2,5
		shw.createShow(0, 0, 0, 0, 0);
		shw.createShow(0, 0, 0, 0, 0);
		shw.createShow(0, 0, 0, 0, 0);
		
		List<Show> sh = shw.getRunningShows();
		for(Show sho: sh)
		{
			System.out.println(sho.movie.Name);
		}
		
		BookingService bSc = new BookingService();
		List<Integer> avlb = bSc.getAvailableTicket(0);
		for(Integer a: avlb)
		{
			System.out.println(a);
		}
		
		
		MyRunnable myRunnable = new MyRunnable(bSc, 0, false, 10000, 0);
		Thread th = new Thread(myRunnable);
		th.start();
		avlb = bSc.getAvailableTicket(0);
		for(Integer a: avlb)
		{
			System.out.println(a);
		}
		
		MyRunnable myRunnable2 = new MyRunnable(bSc, 0, true, 10, 1);
		Thread th2 = new Thread(myRunnable2);
		th2.start();
		avlb = bSc.getAvailableTicket(0);
		for(Integer a: avlb)
		{
			System.out.println(a);
		}
		
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		avlb = bSc.getAvailableTicket(0);
		for(Integer a: avlb)
		{
			System.out.println(a);
		}
		//ShowService()
		
	}
	

}

class MyRunnable implements Runnable {

    private BookingService bookingService;
    private int showId;
    private boolean toBook;
    private int sleepTime;
    private int Id;

    public MyRunnable(BookingService bSrv, int showId, boolean toBook, int SleepTime, int Id) 
    {
        this.bookingService = bSrv;
        this.showId = showId;
        this.toBook = toBook;
        this.sleepTime = SleepTime;
        this.Id = Id;
    }

    public void run()
    {
    	List<Integer> avlb = bookingService.getAvailableTicket(showId);
    	int count = avlb.size();
    	ArrayList<Integer> bookList = new ArrayList<Integer>();
    	for(int i=0;i<count/2;i++)
    	{
    		bookList.add(i);
    		
    	}
    	bookingService.blockTicket(bookList, showId);
    	try {
    		Thread.sleep(1000);
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    	//Make payment here and add Case if Payment Success
    	System.out.println("Execution Started After Thread");
    	if(toBook)
    	{
    		bookingService.bookSeats(bookList, showId);
    	}
    }
}


