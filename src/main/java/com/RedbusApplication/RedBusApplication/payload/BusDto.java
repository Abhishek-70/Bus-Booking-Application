package com.RedbusApplication.RedBusApplication.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {
    private long id;
    private String busNumber;
    private String busType;
    private String price;
    private int totalSeats;
    private int availableSeats;

    private RouteDto route;
    private List<SubRouteDto> subRoutes;
}

