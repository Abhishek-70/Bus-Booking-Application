package com.RedbusApplication.RedBusApplication.repository;

import com.RedbusApplication.RedBusApplication.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository  extends JpaRepository<Bus,Long> {
}
