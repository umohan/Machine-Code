import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GameBoard {
	private int noOfBlock;
	private HashMap<Integer, Ladder> ladders;
	private HashMap<Integer, Snake> snakes;
	private Queue<Long> playersId;
	private HashMap<Long, Player> players;
	
	GameBoard(int noOfBlock) 
	{
		this.ladders = new HashMap<>();
		this.snakes = new HashMap<>();
		this.players = new HashMap<>();
		this.playersId = new LinkedList<>();
		this.noOfBlock = noOfBlock;
	}
	
	public void addPlayer(Player p)
	{
		players.put(p.id,p);
		playersId.offer(p.id);
	}
	
	public void addsnake(Snake s, int head)
	{
		snakes.put(head, s);
	}
	
	public void addLadder(Ladder ld, int ground)
	{
		ladders.put(ground, ld);
	}
	
	public long getNextPLayerId()
	{
		long no= playersId.poll();
		playersId.offer(no);
		return no;
	}
	
	public Player getPlayer(long uuid)
	{
		return players.get(uuid);
	}
	
	public Ladder getLadder(int base)
	{
		if(ladders.containsKey(base))
		{
			return ladders.get(base);
		}
		else
			return null;
	}
	
	public Snake getSnake(int head) {
		if(snakes.containsKey(head))
		{
			return snakes.get(head);
		}
		else
			return null;
	}

}
