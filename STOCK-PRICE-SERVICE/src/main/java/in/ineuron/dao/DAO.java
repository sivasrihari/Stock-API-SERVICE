package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.entity.StockPrice;

@Repository
public interface DAO extends JpaRepository<StockPrice, Integer> {
	public StockPrice findByCompanyName(String companyName);
}
