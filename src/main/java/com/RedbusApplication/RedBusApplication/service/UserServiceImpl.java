package com.RedbusApplication.RedBusApplication.service;

import com.RedbusApplication.RedBusApplication.entity.UserRegistration;
import com.RedbusApplication.RedBusApplication.payload.UserRegistrationDto;
import com.RedbusApplication.RedBusApplication.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    public UserRegistrationDto createUser(UserRegistration userRegistration){
        UserRegistration createdUser = userRegistrationRepository.save(userRegistration);
        UserRegistrationDto userRegistrationDto = mapToDto(createdUser);
        return userRegistrationDto;
    }

    public UserRegistrationDto mapToDto(UserRegistration userRegistration){
        UserRegistrationDto userRegistrationDto=new UserRegistrationDto();
        userRegistrationDto.setId(userRegistration.getId());
        userRegistrationDto.setName(userRegistration.getName());
        userRegistrationDto.setPassword(userRegistration.getPassword());
        userRegistrationDto.setEmail(userRegistration.getEmail());
        userRegistrationDto.setProfilePicture(userRegistration.getProfilePicture());
        return userRegistrationDto;
    }

    public UserRegistration getUserbyId(long id){
     return   userRegistrationRepository.findById(id).get();
    }
}
