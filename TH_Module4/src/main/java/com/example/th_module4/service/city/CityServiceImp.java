package com.example.th_module4.service.city;

import com.example.th_module4.model.City;
import com.example.th_module4.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CityServiceImp implements ICityService{
    @Autowired
    private ICityRepository repository;

    @Override
    public Iterable<City> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
