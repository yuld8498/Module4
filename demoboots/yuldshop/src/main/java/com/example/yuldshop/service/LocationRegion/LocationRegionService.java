package com.example.yuldshop.service.LocationRegion;

import com.example.yuldshop.model.LocationRegion;
import com.example.yuldshop.repository.ILocationRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class LocationRegionService implements ILocationRegionService{
    @Autowired
    private ILocationRegionRepository locationRegionRepository;
    @Override
    public Iterable<LocationRegion> findAll() {
        return null;
    }

    @Override
    public Optional<LocationRegion> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public LocationRegion save(LocationRegion locationRegion) {
        return locationRegionRepository.save(locationRegion);
    }

    @Override
    public void remove(Long id) {

    }
}
