package filters;


public class SimpleFilterFactory {
	public static Filter createFilter (String type, double value, double minVal, double maxVal, double minSoft, double maxSoft, 
			double minRate, double maxRate, double sigma, double ap, double an, int windowSize, boolean isSoft) {

		Filter filter = null;
		
		if(type.equalsIgnoreCase("min")){
			filter = new MinFilter(value, minVal, minSoft, isSoft);
		}
		else if(type.equalsIgnoreCase("max")){
			filter = new MaxFilter(value, maxVal, maxSoft, isSoft);
		}
		else if(type.equalsIgnoreCase("minmax")|| type.equalsIgnoreCase("min max")){
			filter = new MinMaxFilter(value, minVal, maxVal, minSoft, maxSoft, isSoft);
		}
		else if(type.equalsIgnoreCase("rate")){
			filter = new RateFilter(value, minRate, maxRate);
		}
		else if(type.equalsIgnoreCase("standarddeviation") || type.equalsIgnoreCase("standard deviation")){
			filter = new StandardDevFilter(value, sigma, isSoft);
		}
		else if(type.equalsIgnoreCase("hsenvelope")){
			filter = new HSEnvelopeFilter(value, ap, an, windowSize);
		}
		return filter;
		}
}
