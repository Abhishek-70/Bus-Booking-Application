package com.RedbusApplication.RedBusApplication.repository;

import com.RedbusApplication.RedBusApplication.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration,Long> {

}
