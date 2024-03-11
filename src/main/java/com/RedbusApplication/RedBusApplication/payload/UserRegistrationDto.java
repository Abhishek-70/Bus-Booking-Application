package com.RedbusApplication.RedBusApplication.payload;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegistrationDto {
    private long id;
    private String name;
    private String email;
    private String password;
    private byte[] profilePicture;
}
