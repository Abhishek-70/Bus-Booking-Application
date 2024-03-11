package com.RedbusApplication.RedBusApplication.controller;

import com.RedbusApplication.RedBusApplication.entity.UserRegistration;
import com.RedbusApplication.RedBusApplication.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/user")
public class UserRegistrationController {

    @Autowired
    private UserServiceImpl userServiceImpl;


    //1. url-> http://localhost:8090/api/v1/user/creatingUser, with (body->formData-> all Param)
@PostMapping("/creatingUser")
    public ResponseEntity<String> createUser(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            //the datatype to catch a picture from the file is (MULTIPARTFILE)
            @RequestParam("profilePicture") MultipartFile profilePicture
    ) {
        try {
            UserRegistration userRegistration=new UserRegistration();
            userRegistration.setName(name);
            userRegistration.setEmail(email);
            userRegistration.setPassword(password);
            userRegistration.setProfilePicture(profilePicture.getBytes());

            userServiceImpl.createUser(userRegistration);

            return new ResponseEntity<>("User Created Successfully!!", HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("User Not Registered", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //2. Read the user data from the Database via userId,
    //url->http://localhost:8090/api/v1/user/getUser/id pass the id number as path variable
    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserRegistration> getUserbyId(@PathVariable long id){
        UserRegistration foundedUserbyId = userServiceImpl.getUserbyId(id);
        return new ResponseEntity<>(foundedUserbyId,HttpStatus.OK);
    }
}
