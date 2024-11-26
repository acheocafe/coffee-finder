package br.com.coffeefinder.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.coffeefinder.entity.Location;
import br.com.coffeefinder.exception.ResourceNotFoundException;
import br.com.coffeefinder.repository.LocationRepository;
import br.com.coffeefinder.service.interfaces.LocationService;

/**
 * LocationServiceImpl
 */
@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(Long id) throws ResourceNotFoundException {
        return locationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found location"));
    }

    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Location location) throws ResourceNotFoundException {
        Location existingLocation = getLocationById(location.getId());
        if (existingLocation != null) {
            existingLocation.setAddress(location.getAddress());
            existingLocation.setCity(location.getCity());
            existingLocation.setState(location.getState());
            existingLocation.setPostalCode(location.getPostalCode());
            existingLocation.setCountry(location.getCountry());
            return locationRepository.save(existingLocation);
        }
        return null;
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

}
