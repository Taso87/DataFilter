import filters.*;
import oms3.annotations.*;

@Description("Filter to prepare meteorological input data for an hydrological model")
@Documentation("")
@Author(name = "Stefano Tasin, Niccolo' Tubini and Riccardo Rigon", contact = "")
@Keywords("Hydrology")
@Bibliography("MeteoIO")
//@Label()
//@Name()
//@Status(Status.CERTIFIED)
@License("General Public License Version 3 (GPLv3)")
public class DataHandling {
	
	@Description("Type of filter to instantiate")
	@In
	public String filterType;
	
	@Description("The low threshold")
	@In
	public double minVal;

	@Description("The high threshold")
	@In
	public double maxVal;
	
	@Description("")	
	@In
	public double minSoft;
	
	@Description("")	
	@In
	public double maxSoft;

	@Description("")
	@In
	public double minRate;
	
	@Description("")
	@In
	public double maxRate;
	
	@Description("")
	@In
	public double sigma;
	
	@Description("")
	@In
	public double ap;
	
	@Description("")
	@In
	public double an;
	
	@Description("")
	@In
	public int windowSize;
	
	@Description("")
	@In
	public boolean isSoft;
	
	@Execute
	public void process() throws Exception {
		Filter filtro;
		SimpleFilterFactory filterFactory = new SimpleFilterFactory();
		filtro = filterFactory.createFilter(filterType, minVal, maxVal, minSoft, maxSoft, minRate, maxRate, 
				sigma, ap, an, windowSize, isSoft);
		System.out.println(filterType +" created");
		filtro.Print();
	}

}
