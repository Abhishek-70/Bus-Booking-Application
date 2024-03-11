package com.RedbusApplication.RedBusApplication.service;

import com.RedbusApplication.RedBusApplication.entity.Bus;
import com.RedbusApplication.RedBusApplication.entity.Route;
import com.RedbusApplication.RedBusApplication.entity.SubRoute;
import com.RedbusApplication.RedBusApplication.payload.BusDto;
import com.RedbusApplication.RedBusApplication.payload.SubRouteDto;
import com.RedbusApplication.RedBusApplication.repository.BusRepository;
import com.RedbusApplication.RedBusApplication.repository.RouteRepository;
import com.RedbusApplication.RedBusApplication.repository.SubRouteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusServiceImpl {

    @Autowired
    private BusRepository busRepository; // Assuming you have a JpaRepository for Bus entity

    @Autowired
    private ModelMapper modelMapper; // Assuming you're using a mapping library like ModelMapper

    @Autowired
    private RouteRepository routeRepository; // Assuming you have a JpaRepository for Route entity

    @Autowired
    private SubRouteRepository subRouteRepository; // Assuming you have a JpaRepository for Subroute entity

    @Transactional
    public void addBus(BusDto busDto) {
        // 1. Create BUS entity from BusDto
        Bus bus = new Bus();
        bus.setBusType(busDto.getBusType());
        bus.setBusNumber(busDto.getBusNumber());
        bus.setId(busDto.getId());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeats(busDto.getTotalSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());

        // 2. Create the Route Entity from the BusDto -> RouteEntity
        Route route = new Route();
        route.setFromLocation(busDto.getRoute().getFromLocation());
        route.setToLocation(busDto.getRoute().getToLocation());
        route.setFromDate(busDto.getRoute().getFromDate());
        route.setToDate(busDto.getRoute().getToDate());
        route.setTotalDuration(busDto.getRoute().getTotalDuration());
        route.setFromTime(busDto.getRoute().getFromTime());
        route.setToTime(busDto.getRoute().getToTime());

        // 3. Save the main route and get the saved instance
        Route savedRoute = routeRepository.save(route);

        // 4. Associate the BUS and ROUTE
        bus.setRoute(savedRoute);

        // 5. Save the BUS and ROUTE
        Bus savedBus = busRepository.save(bus);

        // 6. Update the Route entity with the busId
        savedRoute.setBus(savedBus);
        routeRepository.save(savedRoute);

        // 6. Check if there are subroutes and save them
        List<SubRouteDto> subRoutes = busDto.getSubRoutes();
        if (subRoutes != null && !subRoutes.isEmpty()) {
            for (SubRouteDto subRouteDto : subRoutes) {
                // Create SubRoute Entity from SubRouteDto
                SubRoute subRoute = new SubRoute();
                subRoute.setFromLocation(subRouteDto.getFromLocation());
                subRoute.setToLocation(subRouteDto.getToLocation());
                subRoute.setFromTime(subRouteDto.getFromTime());
                subRoute.setToTime(subRouteDto.getToTime());
                subRoute.setTotalDuration(subRouteDto.getTotalDuration());
                subRoute.setFromDate(subRouteDto.getFromDate());
                subRoute.setToDate(subRouteDto.getToDate());

                // Set other properties as needed
                // Associate SubRoute with the main Route
                subRoute.setRoute(savedRoute);

                // Save the SubRoute
                subRouteRepository.save(subRoute);


            }
        }
    }

}

