package com.RedbusApplication.RedBusApplication.controller;

import com.RedbusApplication.RedBusApplication.entity.Route;
import com.RedbusApplication.RedBusApplication.payload.BusDto;
import com.RedbusApplication.RedBusApplication.repository.RouteRepository;
import com.RedbusApplication.RedBusApplication.service.BusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private BusServiceImpl busServiceImpl;
    @Autowired
    private RouteRepository routeRepository;

    //url-> http://localhost:8090/api/v1/bus, with a JSON object which consist of BusObject in which a Route And SubRoute Object
    @PostMapping
    public ResponseEntity<String> createBus(@RequestBody BusDto busDto){

       busServiceImpl.addBus(busDto);
        return new ResponseEntity<>("Saved Bus Details!!", HttpStatus.CREATED);
    }

    //Here we try to get the Bus Details from the database using the (From-ToLocation) and (form-Date)
    //http://localhost:8090/api/v1/bus/all, with the required parameters with fromLocation/toLocation/fromDate
    @GetMapping("/all")
    public List<Route> getBuses(
            @RequestParam("fromLocation") String fromLocation,
            @RequestParam("toLocation") String toLocation,
            @RequestParam("formDate") String fromDate
    ){
        List<Route> busByFromLocationToLocationAndFromDate = busServiceImpl.getByFromLocationToLocationAndFromDate(fromLocation, toLocation, fromDate);
        return busByFromLocationToLocationAndFromDate;
    }
}
