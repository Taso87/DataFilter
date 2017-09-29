import org.junit.Test;

public class TestDataHandling {
	
	@Test
	public void Test() throws Exception {
		
		DataHandling dataHandling = new DataHandling();
		/*
		 * You can choose among:
		 * 	Min Filter                --> min
		 * 	Max Filter                --> max
		 *  Min-Max Filter            --> minmax
		 *  Rate Filter               --> rate
		 *  Standard Deviation Filter --> standard deviation
		 *  HS Envelope Filter        --> hsenvelope
		 */
		dataHandling.filterType = "standard deviation";
		dataHandling.minVal     = 10;
		dataHandling.maxVal     = 100;
		dataHandling.minSoft    = 5;
		dataHandling.maxSoft    = 15;
		dataHandling.minRate    = 0;
		dataHandling.maxRate    = 0;
		dataHandling.sigma      = 0;
		dataHandling.ap         = 0;
		dataHandling.an         = 0;
		dataHandling.windowSize = 0;
		dataHandling.isSoft     = true;
		
		dataHandling.process();
	}

}
