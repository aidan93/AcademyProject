package project.business;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import project.entity.Stock;

@Stateless
@Remote(StockBeanRemote.class)
@Local(StockBeanLocal.class)
public class StockBean implements StockBeanLocal, StockBeanRemote {
	@PersistenceContext(unitName = "JPADB")
	private EntityManager entityManager;
	
	public StockBean() {
		
	}

	@Override
	public void saveStock(Stock s) {
		entityManager.persist(s);
		
//		entityManager.merge(s);
//		entityManager.flush();
	}

	@Override
	public void deleteStock(Stock s) {
		//Need to find shipper before deleting
		entityManager.remove(s);
	}

	@Override
	public Stock findStock(Stock s) {
		Stock st = entityManager.find(Stock.class, s.getStockId());
		return st;
	}

	@Override
	public List<Stock> retrieveAllStock() {
		String q = "SELECT s FROM " + Stock.class.getName() + " s";
		Query query = entityManager.createQuery(q);
		List<Stock> stocks = query.getResultList();
		return stocks;
	}
	
	public void clearStock() {
		String q = "DELETE FROM " + Stock.class.getName();
		int rows = entityManager.createQuery(q).executeUpdate();
		
		if(rows > 0) {
			System.out.println("Database Cleared");
		}
	}
}
