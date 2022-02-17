package logic;

import java.util.HashMap;

public class Board implements Cloneable {
	public static final int BOARD_ROW_SIZE = 19;
	
	private HashMap<Integer, PlayerType> pieces;
	  
	public Board()
	{		
		pieces = new HashMap<Integer, PlayerType>();
	}
	
	@Override
	public Board clone() throws CloneNotSupportedException
    {
        // Assign the shallow copy to
        // new reference variable t
		Board board = (Board)super.clone();
 
		board.pieces = pieces;
 
        // Create a new object for the field c
        // and assign it to shallow copy obtained,
        // to make it a deep copy
        return board;
    }
	
	public int getNumberOfPieces()
	{
		return pieces.size();
	}
	
	public boolean PlacePiece(int col, int row, PlayerType player_turn)
	{
		int index_in_map;
		
		if(row >= 323)
			row += 6;
		if(col >= 323)
			col += 6;
		
		index_in_map = (Math.round((float)(row) / 24) - 1) * BOARD_ROW_SIZE 
				+ Math.round((float)(col) / 24) - 1;
				
		if(pieces.containsKey(index_in_map))
		{
			return false;
		}
		pieces.put(index_in_map, player_turn);
		
		return true;
	}
	
	public Sequence getSequecnce(int row, int col, int jumps)
	{
		int pos = PiecePlacementHandler.calculatePosition(row, col);
		Sequence seq = new Sequence(pos);
		
		while(seq.getSeqSize() < 6)
		{
			pos += jumps;
			if(isInSequence(PiecePlacementHandler.calculatePosition(row, col), pos, jumps))
			{
				seq.addToSequence(pos);
			}
			else
				break;
		}
		
		pos = PiecePlacementHandler.calculatePosition(row, col);
		while(seq.getSeqSize() < 6)
		{
			pos -= jumps;
			if(isInSequence(PiecePlacementHandler.calculatePosition(row, col), pos, jumps))
				seq.addToSequence(pos);
			else
				break;
		}
		
		if(seq.getSeqSize() == 0)
			return null;
		
		return seq;
	}
	
	private boolean isInSequence(int addedPos, int pos,  int jumps)
	{
		int xToCheck = PiecePlacementHandler.getX(pos), pieceX = PiecePlacementHandler.getX(addedPos);
		int yToCheck = PiecePlacementHandler.getY(pos), pieceY = PiecePlacementHandler.getY(addedPos);
		
		
		if(!pieces.containsKey(pos))
			return false;
		
		if(pieces.get(pos) != pieces.get(addedPos))
			return false;
		
		// if row then check if the row is still the same
		if(jumps == 1 && yToCheck != pieceY)
			return false;
		
		// if col than nothing
		// if diagnle then check if the diffrence in the row and col are bouth one.
		if((jumps == 20 || jumps == 18) &&
				Math.abs(yToCheck - pieceY) != Math.abs(xToCheck - pieceX))
		{
				return false;
		}
		
		return true;
	}
}
