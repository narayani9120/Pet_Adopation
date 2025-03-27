package com.example.PetAdoption.Services;

import com.example.PetAdoption.Model.PetEntity;
import com.example.PetAdoption.Model.PetImage;
import com.example.PetAdoption.Model.UserEntity;
import com.example.PetAdoption.Repository.PetImageRepository;
import com.example.PetAdoption.Repository.PetRepository;
import com.example.PetAdoption.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PetServiceImp implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetImageRepository petImageRepository;

    @Autowired
    private UserRepository userRepository; // Added UserRepository for validation

    @Override
    public PetImage savePetImage(Integer petId, MultipartFile file) throws IOException {
        PetEntity pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet with ID " + petId + " not found"));

        PetImage petImage = new PetImage();
        petImage.setPet(pet);
        petImage.setImageData(file.getBytes());

        return petImageRepository.save(petImage);
    }

    @Override
    public byte[] getPetImage(Integer imageId) {
        return petImageRepository.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Image with ID " + imageId + " not found"))
                .getImageData();
    }

    @Override
    public PetEntity savePet(PetEntity pet) {
        if (pet.getUser() == null || pet.getUser().getId() == null) {
            throw new RuntimeException("User ID is required to save a pet.");
        }

        UserEntity user = userRepository.findById(pet.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User with ID " + pet.getUser().getId() + " not found"));

        pet.setUser(user); // Ensure the pet is correctly associated with a user
        return petRepository.save(pet);
    }

    @Override
    public List<PetEntity> getAllPets() {
        List<PetEntity> pets= petRepository.findAll();
        System.out.println("Retrieved Users: " + pets);
        return pets;
    }
}
