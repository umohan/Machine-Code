enum UserType
{
	Admin,
	Staff,
	System
}


public class Users 
{
	private String name;
	private UserType user;
	private AccountStatus status;
	private String password;
	
	Users(String name, String password, UserType uTyp)
	{
		this.name = name;
		this.password = password;
		this.user = uTyp;	
	}
}


class AdminUser extends Users
{
	AdminUser(String name, String password, UserType uTyp)
	{
		super(name, password, uTyp);
		
	}
	
	public boolean addParkingFloor() 
	{
		return false;
	}
	
	public boolean addParkingslot(int floorNo, int parkingNo, vechicleType parkingType)
	{
		return false;
	}
	
}

class StaffUser extends Users
{
	StaffUser(String name, String password, UserType uType)
	{
		super(name, password, uType);
	}
	
	public void createTicket()
	{
		
	}
	
	public void processTicket()
	{
		
	}
}


class SystemUser extends Users
{
	SystemUser()
	{
		super("System", "System", UserType.System);
	}
	
	int availableInfloor(int floor, vechicleType vt)
	{
		return 0;
	}
	
	int TotalavailableParking()
	{
		return 1;
	}
	
	int totalAvailableParking(vechicleType vt)
	{
		return 2;
	}
	
}



