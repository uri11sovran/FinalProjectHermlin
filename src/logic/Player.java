package logic;

import java.util.HashMap;
import java.util.LinkedList;

import Helper.Constants;

public class Player {
	private HashMap<SequenceType, LinkedList<Sequence>> sequences;
	
	public Player()
	{
		sequences = new HashMap<SequenceType, LinkedList<Sequence>>();
	}
	
	public int addPosition(int row, int col, Board gameBoard)
	{
		int win_flag = 0;
		Sequence seqToAdd;
		
		for(SequenceTypeCategory Category : SequenceTypeCategory.values())
		{
			if(Category != SequenceTypeCategory.SINGLE)
			{
				seqToAdd = gameBoard.getSequecnce(row, col, Category.getJumps());
				System.out.println(seqToAdd.getSeqType());
				win_flag = addSequenceToList(seqToAdd);
				if(win_flag == Constants.PLAYER_WON)
					break;
			}
		}
		
		return win_flag;
	}
		
	public int addSequenceToList(Sequence seq_to_add)
	{
		if(seq_to_add.getSeqType() == SequenceType.SIX_IN_A_ROW)
			return Constants.PLAYER_WON;
		
		if(!sequences.containsKey(seq_to_add.getSeqType()))
		{
			sequences.put(seq_to_add.getSeqType(), new LinkedList<Sequence>());
		}
		
		sequences.get(seq_to_add.getSeqType()).add(seq_to_add);
		return 1;
	}
}