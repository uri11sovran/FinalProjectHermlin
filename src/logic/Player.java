package logic;

import java.util.HashMap;
import java.util.Iterator;
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
		Sequence seqToAdd;
		
		for(SequenceTypeCategory Category : SequenceTypeCategory.values())
		{
			if(Category != SequenceTypeCategory.SINGLE)
			{
				seqToAdd = gameBoard.getSequecnce(row, col, Category.getJumps());
				//System.out.println(seqToAdd.getSeqType());
				if(seqToAdd.getSeqType() == SequenceType.SIX_IN_A_ROW)
					return Constants.PLAYER_WON;
				
				if(seqToAdd.getSeqType() != SequenceType.SINGLE)
				{
					deleteCoresspondingSequences(seqToAdd);
					addSequenceToList(seqToAdd);
				}
			}
		}
		//printSeqs();
		
		return 0;
	}
	
	public void printSeqs()
	{
		for(SequenceType key : sequences.keySet())
		{
			for(Sequence seq : sequences.get(key))
			{
				 System.out.println(seq.getSeqSize() + " " + seq.getSeqType());
			}
		}
	}
		
	public void addSequenceToList(Sequence seq_to_add)
	{		
		if(!sequences.containsKey(seq_to_add.getSeqType()))
		{
			sequences.put(seq_to_add.getSeqType(), new LinkedList<Sequence>());
		}
		
		sequences.get(seq_to_add.getSeqType()).add(seq_to_add);
	}
	
	public void deleteCoresspondingSequences(Sequence addedSeq)
	{
		Iterator<Sequence> it;
		Sequence currSeq;
		
		for(SequenceType key : sequences.keySet())
		{
			it = sequences.get(key).iterator();
			while(it.hasNext())
			{
				currSeq = it.next();
				if(currSeq.isSubSequence(addedSeq))
				{
					it.remove();
				}
			}
		}
	}
}