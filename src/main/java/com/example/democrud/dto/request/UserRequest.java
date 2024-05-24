package com.example.democrud.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserRequest {
    @Size(min=3, message = "USERNAME_INVALID")
     String username;
     String firstName;
     String lastName;

     LocalDate dob;
//    @Size(min=8, message = "password must be at least 8 character")
@Size(min=8, message = "PASSWORD_INVALID")
     String password;

    public @Size(min = 3, message = "USERNAME_INVALID") String getUsername() {
        return username;
    }

    public void setUsername(@Size(min = 3, message = "USERNAME_INVALID") String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public @Size(min = 8, message = "PASSWORD_INVALID") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 8, message = "PASSWORD_INVALID") String password) {
        this.password = password;
    }
}
