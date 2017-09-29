package filters;


public class SimpleFilterFactory {
	public Filter createFilter (String type, double minVal, double maxVal, double minSoft, double maxSoft, 
			double minRate, double maxRate, double sigma, double ap, double an, int windowSize, boolean isSoft) {

		Filter filter = null;
		if(type.equalsIgnoreCase("min")){
			filter = new MinFilter(minVal, minSoft, isSoft);
		}
		else if(type.equalsIgnoreCase("max")){
			filter = new MaxFilter(maxVal, maxSoft, isSoft);
		}
		else if(type.equalsIgnoreCase("minmax")|| type.equalsIgnoreCase("min max")){
			filter = new MinMaxFilter(minVal, maxVal, minSoft, maxSoft, isSoft);
		}
		else if(type.equalsIgnoreCase("rate")){
			filter = new RateFilter(minRate, maxRate);
		}
		else if(type.equalsIgnoreCase("standarddeviation") || type.equalsIgnoreCase("standard deviation")){
			filter = new StandardDevFilter(sigma, isSoft);
		}
		else if(type.equalsIgnoreCase("hsenvelope")){
			filter = new HSEnvelopeFilter(ap, an, windowSize);
		}
		return filter;
		}
}
