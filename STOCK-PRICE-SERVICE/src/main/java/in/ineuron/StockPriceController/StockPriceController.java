package in.ineuron.StockPriceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.service.IStockPriceService;

@RestController
@RequestMapping("/price")
public class StockPriceController {
	
	@Autowired
	private IStockPriceService service;
	
	@Autowired
	private Environment envi;
	
	@GetMapping("/stockPrice/{companyName}")
	public ResponseEntity<Double> getStockPrice(@PathVariable String companyName)
	{
		Double d=service.findCompanyPrice(companyName);
		System.out.println(companyName + " " + d+"server port ::"+envi.getProperty("local.server.port"));
		return new ResponseEntity<Double>(d,HttpStatus.OK); 
	}
}
