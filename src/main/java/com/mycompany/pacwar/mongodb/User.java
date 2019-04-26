package com.mycompany.pacwar.mongodb;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    public String id;
    public String password;

    public String firstName;
    public String lastName;

    public String email;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
