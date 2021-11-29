import java.security.Timestamp;

enum SEAT_STATUS{
	VACANT,
	OCCUPIED,
	LOCKED,
}


public class Seat {
	int SeatNo;
	int rowNo;
	int columNo;
	SEAT_STATUS status;
	long blockedTime;
	
	public Seat(int SeatNo, int r, int c) {
		this.SeatNo = SeatNo;
		this.rowNo = r;
		this.columNo = c;
		this.status = SEAT_STATUS.VACANT;
		blockedTime = 0;
	}
	
	
}
