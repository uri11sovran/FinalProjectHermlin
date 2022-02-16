package logic;

public enum SequenceType {
	SINGLE(0, SequenceTypeCategory.SINGLE),
	
	DOUBLE_ROW(1, SequenceTypeCategory.ROW),
	TRIPLE_ROW(2, SequenceTypeCategory.ROW), 
	QUADRUPLE_ROW(3, SequenceTypeCategory.ROW),
	QUINTUPLE_ROW(4, SequenceTypeCategory.ROW),
	
	DOUBLE_COL(5, SequenceTypeCategory.COL),
	TRIPLE_COL(6, SequenceTypeCategory.COL), 
	QUADRUPLE_COL(7, SequenceTypeCategory.COL),
	QUINTUPLE_COL(8, SequenceTypeCategory.COL),
	
	DOUBLE_FORWARD_DIAGONAL(9, SequenceTypeCategory.FORWARD_DIAGONAL),
	TRIPLE_FORWARD_DIAGONAL(10, SequenceTypeCategory.FORWARD_DIAGONAL), 
	QUADRUPLE_FORWARD_DIAGONAL(11, SequenceTypeCategory.FORWARD_DIAGONAL),
	QUINTUPLE_FORWARD_DIAGONAL(12, SequenceTypeCategory.FORWARD_DIAGONAL),
	
	DOUBLE_BACKWARD_DIAGONAL(13, SequenceTypeCategory.BACKWARD_DIAGONAL),
	TRIPLE_BACKWARD_DIAGONAL(14, SequenceTypeCategory.BACKWARD_DIAGONAL), 
	QUADRUPLE_BACKWARD_DIAGONAL(15, SequenceTypeCategory.BACKWARD_DIAGONAL),
	QUINTUPLE_BACKWARD_DIAGONAL(16, SequenceTypeCategory.BACKWARD_DIAGONAL),
	
	SIX_IN_A_ROW(17, null);
	
	private SequenceTypeCategory Category;
	private int posVal;
	
	SequenceType(int i, SequenceTypeCategory Category)
	{
		posVal = i;
		this.Category = Category;
	}
	
	public int getPosition()
	{
		return posVal;
	}
	
	public SequenceTypeCategory getCategory()
	{
		return Category;
	}
	
	public int getJumps()
	{
		return Category.getJumps();
	}
	
	static SequenceType getSequenceType(int jumps)
	{
		if(jumps == 1)
			return DOUBLE_ROW;
		
		if(jumps == 19)
			return DOUBLE_COL;
		
		if(jumps == 18)
			return DOUBLE_FORWARD_DIAGONAL;
		
		if(jumps == 20)
		{
			//System.out.println("asd");
			return DOUBLE_BACKWARD_DIAGONAL;
		}
		
		return null;
	}
}
