package logic;

import java.util.ArrayList;
import java.util.Collections;

import Helper.Constants;

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
		sequence.add(pos);
		Collections.sort(sequence);
		
		if(sequence.size() == Constants.SIX_IN_A_ROW)
			seq_type = SequenceType.SIX_IN_A_ROW;
		else
		{
			if(seq_type == SequenceType.SINGLE)
			{
				seq_type = SequenceType.getSequenceType(Math.abs(sequence.get(0) - sequence.get(1)));
			}
			else
				seq_type = SequenceType.values()[seq_type.getPosition() + 1];
		}
		
		return true;
	}
}
