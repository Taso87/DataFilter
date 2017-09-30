package filters;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

import oms3.annotations.Author;
import oms3.annotations.Bibliography;
import oms3.annotations.Description;
import oms3.annotations.Documentation;
import oms3.annotations.Execute;
import oms3.annotations.In;
import oms3.annotations.Keywords;
import oms3.annotations.License;
import oms3.annotations.Out;
import oms3.annotations.Unit;


import org.geotools.feature.SchemaException;
import org.jgrasstools.gears.libs.modules.JGTModel;



import com.vividsolutions.jts.geom.Coordinate;

import filters.Filter;
import filters.SimpleFilterFactory;

@Description("Filter to prepare meteorological input data for an hydrological model")
@Documentation("")
@Author(name = "Stefano Tasin, Niccolo' Tubini and Riccardo Rigon", contact = "")
@Keywords("Hydrology")
@Bibliography("MeteoIO")
//@Label()
//@Name()
//@Status(Status.CERTIFIED)
@License("General Public License Version 3 (GPLv3)")
public class DataHandling extends JGTModel {

	@Description("The Hashmap with the time series of the meteo variable")
	@In
	@Unit ("?")
	public HashMap<Integer, double[]> inData;

	@Description("The double value of the meteo variable, once read from the HashMap")
	double value;
	
	Filter filter;

	@Description("filter type")
	@In
	@Unit ("-")
	public String filterType;
	
	@Description("minVal")
	@In
	@Unit ("-")
	public double minVal;

	@Description("maxVal")
	@In
	@Unit ("-")
	public double maxVal;

	@Description("minSoft")
	@In
	@Unit ("-")
	public double minSoft;

	@Description("maxSoft")
	@In
	@Unit ("-")
	public double maxSoft;

	@Description("minRate")
	@In
	@Unit ("-")
	public double minRate;

	@Description("maxRate")
	@In
	@Unit ("-")
	public double maxRate;

	@Description("sigma")
	@In
	@Unit ("-")
	public double sigma;

	@Description("ap")
	@In
	@Unit ("-")
	public double ap;

	@Description("an")
	@In
	@Unit ("-")
	public double an;

	@Description("windowSize")
	@In
	@Unit ("hour")
	public int windowSize;

	@Description("isSoft")
	@In
	@Unit ("-")
	public boolean isSoft;

	@Description("the linked HashMap with the coordinate of the stations")
	LinkedHashMap<Integer, Coordinate> stationCoordinates;

	@Description("the output hashmap withe filtered values")
	@Out
	public HashMap<Integer, double[]> outData= new HashMap<Integer, double[]>();

	/**
	 * Process.
	 *
	 * @throws Exception the exception
	 */
	@Execute
	public void process() throws Exception { 

		checkNull(inData);


		// reading the ID of all the stations 
		Set<Entry<Integer, double[]>> entrySet = inData.entrySet();

		for (Entry<Integer, double[]> entry : entrySet) {
			Integer ID = entry.getKey();

			value=inData.get(ID)[0];
//            double filtered=(value<minVal)?JGTConstants.doubleNovalue:value;
		
			double filtered=computeFilt();
		
			/**Store results in Hashmaps*/
			storeResult((Integer)ID,filtered);

		}


	}


	/**
	 * Filter values with the choosen filter.
	 *
	 * @param parametri
	 * @return the filtered values
	 */

	private double computeFilt(){
			// compute 

			filter=SimpleFilterFactory.createFilter(filterType, value, minVal, maxVal, minSoft, maxSoft, minRate, maxRate, sigma, ap, an, windowSize, isSoft);
		
			return filter.compute();

	}


	/**
	 * Store result in given hashpmaps.
	 *
	 * @param downwellingALLSKY: the downwelling radiation in all sky conditions
	 * @param upwelling: the upwelling radiation
	 * @param longwave: the longwave radiation
	 * @throws SchemaException 
	 */
	private void storeResult(Integer ID,double filtered) 
			throws SchemaException {

		outData.put(ID, new double[]{filtered});

	}

}
