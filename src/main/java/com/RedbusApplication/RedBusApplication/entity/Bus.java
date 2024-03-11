package com.RedbusApplication.RedBusApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String busNumber;
    private String busType;
    private String price;
    private int totalSeats;
    private int availableSeats;

    @OneToOne(mappedBy = "bus")
    private Route route;

}
