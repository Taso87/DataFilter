package filters;

public class RateFilter implements Filter{
	
	/** */
	double minRate;
	
	/** */
	double maxRate;
	
	
	
	/**
	 * Instantiates a new RateFilter.
	 *
	 * @param minRate
	 * @param maxRate
	 */
	public RateFilter(double value, double minRate, double maxRate) {
		System.out.println("Filter selected: RateFilter");
		this.minRate = minRate;
		this.maxRate = maxRate;
	}
	
	public void Print(){
		System.out.println("Filter's parameters are: \n"
				+ "	min_rate: "  + minRate  + "\n"
				+ "	max_rate: "  + maxRate  + "\n");
	}
	
	
	@Override
	public double compute(){
		return -999;
	}
}
