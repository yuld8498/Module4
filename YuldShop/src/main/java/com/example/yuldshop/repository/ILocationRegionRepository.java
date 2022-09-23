package com.example.yuldshop.repository;

import com.example.yuldshop.model.LocationRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRegionRepository extends JpaRepository<LocationRegion, Long> {
}
