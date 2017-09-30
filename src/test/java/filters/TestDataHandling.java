/*
 * This file is part of JGrasstools (http://www.jgrasstools.org)
 * (C) HydroloGIS - www.hydrologis.com 
 * 
 * JGrasstools is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package filtersTest;

import filters.*;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.HashMap;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.jgrasstools.gears.io.shapefile.OmsShapefileFeatureReader;
import org.jgrasstools.gears.io.timedependent.OmsTimeSeriesIteratorReader;
import org.jgrasstools.gears.io.timedependent.OmsTimeSeriesIteratorWriter;

/**
 * @author Stefano Tasin
 */
public class TestDataHandling {
	
	@Test
	public void Test() throws Exception {


		String startDate = "2010-10-01 00:00" ;
		String endDate = "2010-10-21 16:00";
		int timeStepMinutes = 60;
		String fId = "ID";
		String inPathToData ="resources/TA_test.csv";
		String outPathToData= "resources/TA_filtered.csv";

		OmsTimeSeriesIteratorReader dataReader = getTimeseriesReader(inPathToData, fId, startDate, endDate, timeStepMinutes);

		OmsTimeSeriesIteratorWriter dataWriter = new OmsTimeSeriesIteratorWriter();
		dataWriter.file = outPathToData;
		dataWriter.tStart = startDate;
		dataWriter.tTimestep = timeStepMinutes;
		dataWriter.fileNovalue="-9999";


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
		dataHandling.filterType = "min";
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
		
		while( dataReader.doProcess ) { 		

			dataReader.nextRecord();	
			HashMap<Integer, double[]> id2ValueMap = dataReader.outData;
			dataHandling.inData= id2ValueMap;
			

			dataHandling.process();
			
			
			HashMap<Integer, double[]> outData = dataHandling.outData;
	            
				dataWriter.inData = outData;
				dataWriter.writeNextLine();
				
				
				
				if (outPathToData != null) {
					dataWriter.close();
}

		}


	}

	private OmsTimeSeriesIteratorReader getTimeseriesReader( String inPath, String id, String startDate, String endDate,
			int timeStepMinutes ) throws URISyntaxException {
		OmsTimeSeriesIteratorReader reader = new OmsTimeSeriesIteratorReader();
		reader.file = inPath;
		reader.idfield = "ID";
		reader.tStart = startDate;
		reader.tTimestep = timeStepMinutes;
		reader.tEnd = endDate;
		reader.fileNovalue = "-9999";
		reader.initProcess();
		return reader;
	}

}
