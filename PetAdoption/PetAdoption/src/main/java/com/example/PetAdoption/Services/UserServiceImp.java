package com.example.PetAdoption.Services;

import com.example.PetAdoption.Model.UserEntity;
import com.example.PetAdoption.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements Userservice {
    private  final UserRepository userRepository;


    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        System.out.println("Retrieved Users: " + users);
        return users;
    }


    public Optional<UserEntity> getUserById(Integer id) {
        return userRepository.findById(id);
    }


    public Optional<UserEntity> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public boolean authenticate(String email, String password) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        return user.isPresent() && user.get().getPassword().equals(password);
    }


    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
