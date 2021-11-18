enum PLAYER_STATUS{
	NotStarted,
	Playing,
	Won,
	Lost;
}


public class Player {
	private int position;
	private PLAYER_STATUS status;
	public long id;
	private String Name;
	
	Player(String Name, int id)
	{
		this.Name = Name;
		this.id = id;
		this.position = 0;
	}
	
	public int getPosition()
	{
		return this.position;
	}
	
	public PLAYER_STATUS getStatus()
	{
		return this.status;
	}
	
	public String getName()
	{
		return this.Name;
	}
	
	public void updatePosition(int no)
	{
		this.position = no;
		if(no == 100)
		{
			status  = PLAYER_STATUS.Won;
		}
	}
	
}
