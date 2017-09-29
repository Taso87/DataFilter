package filters;

public class StandardDevFilter implements Filter{
	
	/** */
	double sigma;
	
	/** */
	boolean isSoft;
	
	
	
	/**
	 * Instantiates a new StandardDevFilter.
	 *
	 * @param sigma
	 * @param isSoft
	 */
	public StandardDevFilter(double sigma, boolean isSoft) {
		System.out.println("Filter selected: StandardDevFilter");
		this.sigma = sigma;
		this.isSoft = isSoft;
	}
	
	public void Print(){
		System.out.println("Filter's parameters are: \n"
				+ "	sigma: "       + sigma   + "\n"
				+ "	is_soft: "     + isSoft  + "\n");
	}
}