package filters;

public class MaxFilter implements Filter{
	
	/** The high threshold*/
	double maxVal;
	
	/** */
	double maxSoft;
	
	/** */
	boolean isSoft;
	
	
	
	/**
	 * Instantiates a new MaxFilter.
	 *
	 * @param maxVal is the high threshold
	 * @param maxSoft
	 * @param isSoft
	 */
	public MaxFilter(double value, double maxVal, double maxSoft, boolean isSoft) {
		System.out.println("Filter selected: MinFilter");
		this.maxVal = maxVal;
		this.maxSoft = maxSoft;
		this.isSoft = isSoft;
	}
	
	public void Print(){
		System.out.println("Filter's parameters are: \n"
				+ "	max_val:  " + maxVal  + "\n"
				+ "	max_soft: " + maxSoft + "\n"
				+ "	is_soft:  " + isSoft  + "\n");
	}
	
	@Override
	public double compute(){
		return -999;
	}
}
