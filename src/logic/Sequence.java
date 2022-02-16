package logic;

import java.util.ArrayList;
import java.util.Collections;

public class Sequence {
	private ArrayList<Integer> sequence;
	private SequenceType seq_type;
	
	public Sequence(int pos)
	{
		seq_type = SequenceType.SINGLE;
		sequence = new ArrayList<Integer>();
		sequence.add(pos);
	}
	
	public int getSeqSize()
	{
		return sequence.size();
	}
	
	public SequenceType getSeqType()
	{
		return seq_type;
	}
	
	public ArrayList<Integer> getsequence()
	{
		return sequence;
	}
	
	public boolean addToSequence(int pos)
	{
		//if(!isInSameSequence(pos))
			//return false;
		
		sequence.add(pos);
		Collections.sort(sequence);
		
		if(sequence.size() == 6)
			seq_type = SequenceType.SIX_IN_A_ROW;
		else
		{
			if(seq_type == SequenceType.SINGLE)
			{
				seq_type = SequenceType.getSequenceType(Math.abs(sequence.get(0) - sequence.get(1)));
			}
			else
			{
				seq_type = SequenceType.values()[seq_type.getPosition() + 1];
				//System.out.println(Math.abs(sequence.get(0) - sequence.get(1)) + " " + seq_type.getPosition());
			}
		}
		
		return true;
	}
	
	/*public boolean isInSameSequence(int pos)
	{
		if(seq_type == SequenceType.SINGLE && 
				SequenceType.getSequenceType(Math.abs(sequence.get(0) - pos)) != null)
			return true;

		return sequence.get(0) - pos == seq_type.getJumps() ||
				pos - sequence.get(sequence.size() - 1) == seq_type.getJumps();
	}*/
}
