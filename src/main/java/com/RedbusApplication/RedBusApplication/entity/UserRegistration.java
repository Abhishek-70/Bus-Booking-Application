package com.RedbusApplication.RedBusApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistration {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;

    //it's annotation used for the uploading the image into the database(@LOB) it takes the value in the form of byte[] array
    @Lob
    @Column(name="profile_picture",length=1024)
    private byte[] profilePicture;
}
