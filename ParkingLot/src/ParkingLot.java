import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

enum vechicleType
{
	CAR,
	TRUCK,
	Cycle,
	Bike;
}



enum TicketStatus
{
	ACTIVE, PAID, LOST;
}

enum AccountStatus
{
	ACTIVE, BLOCKED, EXPIRED
}


class ParkingSpot
{
	//Auto Assign
	int SpotNo;
	vechicleType[] vType;
	int floorNo;
	boolean status;
	
	ParkingSpot(int floorNo, vechicleType[] Vtype, int spot)
	{
		this.floorNo = floorNo;
		vType = new vechicleType[Vtype.length];
		for(int i=0;i<Vtype.length;i++)
		{
			vType[i] = Vtype[i];
		}
		status = false;
		
		this.SpotNo = spot;
	}
	
	public boolean getStatus()
	{
		return status;
	}
	
	public boolean allot()
	{
		if(!status)
		{
			status = true;
			return true;
		}
		else
			return false;
	}
	
	public void free()
	{
		status = false;
	}
}



class ParkingFloor
{
	int floorNo;
	private int avaialableNo;
	private int occupied;
	private int totalNo;
	private Queue<Integer> availablPoint;
	private Map<Integer, ParkingSpot> parkingPoint;
	
	ParkingFloor(int Floor)
	{
		floorNo = Floor;
		avaialableNo = 0;
		occupied = 0;
		totalNo = 0;
		availablPoint = new LinkedList<>();
		parkingPoint = new HashMap<>();
		
	}
	
	public void addParkingSpot(vechicleType[] Vtype)
	{
		ParkingSpot pSpt = new ParkingSpot(floorNo, Vtype, avaialableNo);
		availablPoint.add(avaialableNo);
		parkingPoint.put(avaialableNo, pSpt);
		avaialableNo+=1;
		totalNo+=1;
	}
	
	public boolean isAvailable()
	{
		if(avaialableNo > 0)
			return true;
		else
			return false;
	}
	
	public int allocateParking()
	{
		if(availablPoint.size() <0)
			return -1;
		else
		{
			int parkingNo = availablPoint.poll();
			parkingPoint.get(parkingNo).allot();
			return parkingNo;
		}
	}
	
	public void freeParking(int parkingNo)
	{
		parkingPoint.get(parkingNo).free();
		availablPoint.add(parkingNo);
	}
	
}



public class ParkingLot 
{
	String Name;
	String Address;
	int noOfFloor;
	vechicleType [] typeofVechicle;
	ParkingFloor pfloor[];
	int totalAvlbcnt;
	
	
	ParkingLot(String Name, String address, int noOfFloor)
	{
		this.Name = Name;
		this.Address = address;
		this.noOfFloor = noOfFloor;
		pfloor = new ParkingFloor[noOfFloor];
		totalAvlbcnt=0;
	}
	
	protected void addParking(int floor,vechicleType[] Vtype)
	{
		pfloor[floor].addParkingSpot(Vtype);
		totalAvlbcnt += 1;
	}
	
	public String AllocateParking()
	{
		String res = "";
		for(int i=0;i<noOfFloor;i++)
		{
			if(pfloor[i].isAvailable())
			{
				int no = pfloor[i].allocateParking();
				res = ""+i+"-"+"no";
				System.out.println("Allocated "+res);
			}
		}
		return res;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public String getAddress(String address)
	{
		return Address;
	}
	
	
}


