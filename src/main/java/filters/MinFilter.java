package filters;

public class MinFilter implements Filter {
	
	/** The low threshold*/
	double minVal;
	
	/** */
	double minSoft;
	
	/** */
	boolean isSoft;

	
	
	/**
	 * Instantiates a new MinFilter.
	 *
	 * @param minVal is the low threshold
	 * @param minSoft
	 * @param isSoft
	 */
	public MinFilter(double minVal, double minSoft, boolean isSoft) {
		System.out.println("Filter selected: MinFilter");
		this.minVal = minVal;
		this.minSoft = minSoft;
		this.isSoft = isSoft;
	}
	
	public void Print(){
		System.out.println("Filter's parameters are: \n"
				+ "	min_val:  " + minVal  + "\n"
				+ "	min_soft: " + minSoft + "\n"
				+ "	is_soft:  " + isSoft  + "\n");
	}

}
