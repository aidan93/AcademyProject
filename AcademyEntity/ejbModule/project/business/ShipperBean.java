package project.business;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import project.entity.Shipper;

@Stateless
@Remote(ShipperBeanRemote.class)
@Local(ShipperBeanLocal.class)
public class ShipperBean implements ShipperBeanLocal, ShipperBeanRemote {
	@PersistenceContext(unitName = "JPADB")
	private EntityManager entityManager;
	
	public ShipperBean() {
		
	}
	
	@Override
	public void saveShipper(Shipper s) {
		// TODO Auto-generated method stub
		
		//entityManager.persist(s);
		
		//Allows adds and edits
		entityManager.merge(s);
		entityManager.flush();
	}

	@Override
	public Shipper findShipper(Shipper sh) {
		// TODO Auto-generated method stub
		Shipper s = entityManager.find(Shipper.class, sh.getShipperid());
		return s;
	}

	@Override
	public List<Shipper> retrieveAllShippers() {
		// TODO Auto-generated method stub
		String q = "SELECT s FROM " + Shipper.class.getName() + " s";
		Query query = entityManager.createQuery(q);
		List<Shipper> shippers = query.getResultList();
		return shippers;
	}

	@Override
	public void deleteShipper(Shipper s) {
		//Need to find shipper before deleting
		entityManager.remove(s);
	}

}
