package br.com.coffeefinder.service.interfaces;

import java.util.List;
import br.com.coffeefinder.entity.Location;

public interface LocationService {

	List<Location> getAllLocations();

	Location getLocationById();

	Location createLocation(Location location);

	Location updateLocation(Location location);

	void deleteLocation();

}
