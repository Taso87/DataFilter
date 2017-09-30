package filters;

public class MinMaxFilter implements Filter{
	
	/** */
	double minVal;
	
	/** */
	double maxVal;
	
	/** */
	double minSoft;
	
	/** */
	double maxSoft;
	
	/** */
	boolean isSoft;
	
	
	/**
	 * Instantiates a new MinMaxFilter.
	 *
	 * @param minVal is the low threshold
	 * @param maxVal is the high threshold
	 * @param minSoft
	 * @param maxSoft
	 * @param isSoft
	 */
	public MinMaxFilter(){
		System.out.println("Filter selected: MinMaxFilter");
	}
	public MinMaxFilter(double value, double minVal, double maxVal, double minSoft, double maxSoft, boolean isSoft) {
		System.out.println("Filter selected: MinMaxFilter");
		this.minVal = minVal;
		this.maxVal = maxVal;
		this.minSoft = minSoft;
		this.maxSoft = maxSoft;
		this.isSoft = isSoft;
	}
	
	@Override
	public void Print(){
		System.out.println("Filter's parameters are: \n"
				+ "	min_val: "  + this.minVal  + "\n"
	     		+ "	max_val: "  + this.maxVal  + "\n"
				+ "	min_soft: " + this.minSoft + "\n"
				+ "	max_soft: " + this.maxSoft + "\n"
				+ "	is_soft: "  + this.isSoft  + "\n");
		
	}
	
	/*public double Sum(double add1, double add2){
		double sum;
		sum = add1 + add2;
		return sum;
	}
	*/
	
	@Override
	public double compute(){
		return -999;
	}
	
}
