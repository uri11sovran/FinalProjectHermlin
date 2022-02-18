package logic;

public class PiecePlacementHandler {
	public static int calculatePosition(int row, int col)
	{
		return (row * Game.NUM_OF_CELLS + col);
	}
	
	public static int getX(int pos)
	{
		return pos - getY(pos) * Game.NUM_OF_CELLS;
	}
	
	public static int getY(int pos)
	{
		return pos / Game.NUM_OF_CELLS;
	}
	
	public static int GetReletivePosition(int pos)
	{
		int reletive_pos = Math.round((float)(pos) / Game.CELL_SIZE);

		if(((pos) / Game.CELL_SIZE) < 9)
		{
			pos = ((pos) / Game.CELL_SIZE) * Game.CELL_SIZE + Game.CELL_SIZE - reletive_pos;
		}
		else
			pos = reletive_pos * Game.CELL_SIZE + Game.CELL_SIZE - reletive_pos;
		
		return pos;
	}
}
