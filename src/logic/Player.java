package logic;

import java.util.HashMap;
import java.util.LinkedList;

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
				if(win_flag == 2)
					return win_flag;
			}
		}
		
		return win_flag;
	}
		
	public int addSequenceToList(Sequence seq_to_add)
	{
		if(seq_to_add.getSeqType() == SequenceType.SIX_IN_A_ROW)
			return 2;
		
		if(!sequences.containsKey(seq_to_add.getSeqType()))
		{
			sequences.put(seq_to_add.getSeqType(), new LinkedList<Sequence>());
		}
		
		sequences.get(seq_to_add.getSeqType()).add(seq_to_add);
		return 1;
	}
	
	/*public int addToExistingSequence(int pos, SequenceTypeCategory category)
	{
		ArrayList<Sequence> addedSequences = new ArrayList<Sequence>();
		Iterator<Sequence> it;
		
		for(SequenceType type : sequences.keySet())
		{
			if(type.getCategory() == category)
			{
				it = sequences.get(type).iterator();
				while(it.hasNext())
				{
					Sequence seq = it.next();
					if(seq.addToSequence(pos))
					{
						if(seq.getSeqSize() == 6)
							return 2;
						
						// delete from former sequence list and added to new one
						it.remove();
						
						//System.out.println(seq.getSeqType() + " " + sequences.size());
						
						if(!sequences.containsKey(seq.getSeqType()))
							sequences.put(seq.getSeqType(), new LinkedList<Sequence>());
						sequences.get(seq.getSeqType()).add(seq);
						
						addedSequences.add(seq);
					}
				}
			}
		}
		
		if(addedSequences.size() == 0)
			return 0;
		return 1;
	}*/
	
	/*
	 * public int addSequences(int row, int col)
	{
		int won_flag = 0;
		
		won_flag = addSequenceToList(Board.getSequecnce(row, col, 1));
		
		if(won_flag != 2)
			won_flag = addSequenceToList(Board.getSequecnce(row, col, 19));
		
		if(won_flag != 2)
			won_flag = addSequenceToList(Board.getSequecnce(row, col, 20));
		
		if(won_flag != 2)
			won_flag = addSequenceToList(Board.getSequecnce(row, col, 18));
		
		return won_flag;
	}
	
	public int addSequenceToList(Sequence seq_to_add)
	{
		if(seq_to_add.getSeqType() == SequenceType.SIX_IN_A_ROW)
			return 2;
		
		if(seq_to_add.getSeqType() != SequenceType.SINGLE)
		{
			if(!sequences.containsKey(seq_to_add.getSeqType()))
				sequences.put(seq_to_add.getSeqType(), new LinkedList<Sequence>());
			
			sequences.get(seq_to_add.getSeqType()).add(seq_to_add);
			return 1;
		}
		
		return 0;
	}
	 */
}