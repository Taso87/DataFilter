package filters;

import org.jgrasstools.gears.libs.modules.JGTConstants;

public class HSEnvelopeFilter implements Filter{
	
	/** */
	double ap;
	
	/** */
	double an;
	
	/** */
	int windowSize;
	
	
	
	/**
	 * Instantiates a new HSEnvelopFilter.
	 *
	 * @param ap
	 * @param an
	 * @param windowSize
	 */
	public HSEnvelopeFilter(double value, double ap, double an, int windowSize) {
		System.out.println("Filter selected: HSEnvelope");
		this.ap = ap;
		this.an = an;
		this.windowSize = windowSize;
	}
	
	public void Print(){
		System.out.println("Filter's parameters are: \n"
				+ "	ap: "          + ap          + "\n"
				+ "	an: "          + an          + "\n"
				+ "	windowSize: "  + windowSize  + "\n");
	}
	
	@Override
	public double compute(){
		return -999;
	}
}
