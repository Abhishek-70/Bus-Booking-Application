package com.RedbusApplication.RedBusApplication.controller;

import com.RedbusApplication.RedBusApplication.payload.BusDto;
import com.RedbusApplication.RedBusApplication.service.BusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private BusServiceImpl busServiceImpl;
    //url-> http://localhost:8090/api/v1/bus, with a JSON object which consist of BusObject in which a Route And SubRoute Object
    @PostMapping
    public ResponseEntity<String> createBus(@RequestBody BusDto busDto){

       busServiceImpl.addBus(busDto);
        return new ResponseEntity<>("Saved Bus Details!!", HttpStatus.CREATED);
    }
}
