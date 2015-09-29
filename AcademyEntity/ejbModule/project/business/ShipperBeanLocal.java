package project.business;

import java.util.List;

import javax.ejb.Local;

import project.entity.Shipper;

@Local
public interface ShipperBeanLocal {
	void saveShipper(Shipper s);
	void deleteShipper(Shipper s);
	Shipper findShipper(Shipper s);
	List<Shipper> retrieveAllShippers();
}
