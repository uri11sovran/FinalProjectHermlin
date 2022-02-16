package logic;

public class PiecePlacementHandler {
	public static int calculatePosition(int row, int col)
	{
		return (row * 19 + col);
	}
	
	public static int getX(int pos)
	{
		return pos - getY(pos) * 19;
	}
	
	public static int getY(int pos)
	{
		return pos / 19;
	}
	
	public static int GetReletivePosition(int pos)
	{
		//int reletive_pos = Math.round((float)(pos - 12) / 24);
		int reletive_pos = Math.round((float)(pos) / 24);

		if(((pos) / 24) < 9)
		{
			pos = ((pos) / 24) * 24 + 24 - reletive_pos;
		}
		else
			pos = reletive_pos * 24 + 24 - reletive_pos;
		
		return pos;
	}
}
