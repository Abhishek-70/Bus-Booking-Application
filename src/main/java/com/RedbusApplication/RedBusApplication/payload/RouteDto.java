package com.RedbusApplication.RedBusApplication.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

    private String fromLocation;
    private String toLocation;
    private LocalDate fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
}
