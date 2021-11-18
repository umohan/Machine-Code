
public class GameService {
	GameBoard gb;
	int tempUuid;
	boolean gotWinner;
	final int noOfBlock = 100;
	Dice dc;
	
	GameService()
	{
		gb = new GameBoard(noOfBlock);
		tempUuid = 0;
		gotWinner = false;
		dc = new Dice();
	}
	
	public void addPlayer(String PlayerName)
	{
		Player pp = new Player(PlayerName, tempUuid);
		gb.addPlayer(pp);
		tempUuid ++;
	}
	
	public boolean addSnakes(int head, int tail)
	{
		if(head>noOfBlock || tail> noOfBlock)
		{
			System.out.println("Invalid Snake");
			return false;
		}
		
		Snake snk = new Snake(head, tail);
		gb.addsnake(snk, head);
		return true;
	}
	
	public boolean addLadder(int start, int end)
	{
		if(start>noOfBlock || end> noOfBlock)
		{
			System.out.println("Invalid ladder");
			return false;
		}
		Ladder ld = new Ladder(start, end);
		gb.addLadder(ld, end);
		return true;
	}
	
	public void startGame()
	{
		while(!gotWinner)
		{
			long pId = gb.getNextPLayerId();
			Player p = gb.getPlayer(pId);
			int diceCall = dc.getValue();
			System.out.println("Dice Value -"+ diceCall);
			if(p.getPosition() == 0 && diceCall != 6)
			{
				continue;
			}
			else
			{
				int current_pos = p.getPosition();
				int updated_pos = current_pos+diceCall;
				if(gb.getSnake(updated_pos) != null)
				{
					updated_pos = gb.getSnake(updated_pos).getTail();
				}
				else if(gb.getLadder(updated_pos)!= null)
				{
					updated_pos = gb.getLadder(updated_pos).getTop();
				}
				p.updatePosition(updated_pos);
				if(updated_pos ==100)
				{
					System.out.println("Game Completed :- Winner UserName:- "+p.getName());
					gotWinner = true;
				}
				System.out.println("Current Position of Player "+p.getName()+" is "+p.getPosition());
			}
		}
	}
}
