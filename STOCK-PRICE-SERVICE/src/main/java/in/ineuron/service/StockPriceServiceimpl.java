package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.DAO;
import in.ineuron.entity.StockPrice;
import in.ineuron.exception.StockNotFoundException;

@Service
public class StockPriceServiceimpl implements IStockPriceService {

	@Autowired
	private DAO dao;
	@Override
	public Double findCompanyPrice(String ComanyName) 
	{
		StockPrice stockPrice=dao.findByCompanyName(ComanyName);
		if (stockPrice == null)
		{
			throw new StockNotFoundException("Company not vailable");
		}

		return stockPrice.getCompanyPrice();
		
	}

}
