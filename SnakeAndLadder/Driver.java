import java.io.*;
import java.util.*;

public class Driver {

	public static void main(String[] args)throws Exception
	{
		GameService Gs = new GameService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		System.out.println("Enter No of Snake");
		int nos = Integer.parseInt(br.readLine());
		System.out.println("Enter head and tail Position Head >tail");
		for(int i=0;i<nos;i++)
		{
			st = new StringTokenizer(br.readLine());
			Gs.addSnakes(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		System.out.println("Enter No of Ladder");
		nos = Integer.parseInt(br.readLine());
		System.out.println("Enter Top and Bottom Position of Ladder Top > Bottom");
		for(int i=0;i<nos;i++)
		{
			st = new StringTokenizer(br.readLine());
			Gs.addLadder(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		
		System.out.println("Enter No of Player");
		nos = Integer.parseInt(br.readLine());
		System.out.println("Enter Player Name");
		for(int i=0;i<nos;i++)
		{
			Gs.addPlayer(br.readLine());
		}
		
		System.out.println("Starting Game");
		Gs.startGame();
		
	}

}
