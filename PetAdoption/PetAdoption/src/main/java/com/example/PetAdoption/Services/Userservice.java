package com.example.PetAdoption.Services;

import com.example.PetAdoption.Model.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface Userservice {
    List<UserEntity> getAllUsers();

    UserEntity saveUser(UserEntity user);

    boolean authenticate(String email, String password);
}
