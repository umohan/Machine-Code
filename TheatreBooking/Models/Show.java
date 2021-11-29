enum SHOW_STATUS
{
	COMPLETED,
	ACTIVE;
}

public class Show {
	int UID;
	long startTime;
	long endTime;
	Movie movie;
	Screen screen;
	SHOW_STATUS sts= SHOW_STATUS.ACTIVE;
	
	Show(int UID, long startTime, long endTime, Movie movie, Screen screen)
	{
		this.UID = UID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.movie = movie;
		this.screen = screen;
		
	}
	
}
