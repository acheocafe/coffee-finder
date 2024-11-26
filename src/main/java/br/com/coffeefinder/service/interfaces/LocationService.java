package br.com.coffeefinder.service.interfaces;

import java.util.List;
import br.com.coffeefinder.entity.Location;
import br.com.coffeefinder.exception.ResourceNotFoundException;

public interface LocationService {

	List<Location> getAllLocations();

	Location getLocationById(Long id) throws ResourceNotFoundException;

	Location createLocation(Location location);

	Location updateLocation(Location location) throws ResourceNotFoundException;

	void deleteLocation(Long id);

}
