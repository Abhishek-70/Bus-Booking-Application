package com.RedbusApplication.RedBusApplication.repository;

import com.RedbusApplication.RedBusApplication.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {
      List<Route> findBusByFromLocationToLocationAndFromDate(String fromLocation,String toLocation,String fromDate);
}
