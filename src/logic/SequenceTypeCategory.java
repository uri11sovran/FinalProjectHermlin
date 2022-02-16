package logic;

public enum SequenceTypeCategory {
	SINGLE(0),
	ROW(1),
	COL(19),
	FORWARD_DIAGONAL(18),
	BACKWARD_DIAGONAL(20);

	private int jumps;
	
	public int getJumps()
	{
		return jumps;
	}
	
	SequenceTypeCategory(int jumps) {
		this.jumps = jumps;
	}
}
