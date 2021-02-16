package Dao;

import java.util.List;

import Models.Plane;
import Models.User;

public interface PlaneDao {
	/**
	 * @return this list of planes
	 */
	List<User> getPlanes();
	
	/**
	 * @param planeID
	 * @return a specific plane
	 */
	Plane getPlane(String planeID);
	
	/**
	 * 
	 * @return a new plane
	 */
	User postPlane();
	
	/**
	 * 
	 * @return the update of the plane
	 */
	User putPlane();
	
	/**
	 * 
	 * @return true if the plane is successfully deleted, false otherwise
	 */
	boolean deletePlane();
}
