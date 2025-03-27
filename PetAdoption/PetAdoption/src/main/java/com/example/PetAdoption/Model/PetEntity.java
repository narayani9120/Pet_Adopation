package com.example.PetAdoption.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate ID
    @Column(name = "pet_id")
    private Integer PetId;
    public String Name;
    public Integer Age;
    public Gender Gender;
    public String Breed;
    public Category Category;
    @Column(name = "PetCharacter")
    public String PetCharacter;
    public String Colour;
    private Size Size;
    public String VaccinationDetails;
    public String Address;
    public String Description;



    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PetImage> images;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private UserEntity user;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();


    public PetEntity() {
        super();
    }

    public PetEntity(Integer petId, String name, Integer age, Gender gender, String breed, Category category,
                     String petCharacter, String colour, Size size, String vaccinationDetails, String address,
                     String description) {
        this.PetId = petId;
        this.Name = name;
        this.Age = age;
        this.Gender = gender;
        this.Breed = breed;
        this.Category = category;
        this.PetCharacter = petCharacter;
        this.Colour = colour;
        this.Size = size;
        this.VaccinationDetails = vaccinationDetails;
        this.Address = address;
        this.Description = description;

    }

    public enum Gender { Male, Female }
    public enum Category { Dog, Cat, Bird, Other }
    public enum Size { small, medium, large }

    public Integer getPetId() {
        return PetId;
    }

    public void setPetId(Integer petId) {
        PetId = petId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public PetEntity.Gender getGender() {
        return Gender;
    }

    public void setGender(PetEntity.Gender gender) {
        Gender = gender;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public PetEntity.Category getCategory() {
        return Category;
    }

    public void setCategory(PetEntity.Category category) {
        Category = category;
    }

    public String getPetCharacter() {
        return PetCharacter;
    }

    public void setPetCharacter(String petCharacter) {
        PetCharacter = petCharacter;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        Colour = colour;
    }

    public PetEntity.Size getSize() {
        return Size;
    }

    public void setSize(PetEntity.Size size) {
        Size = size;
    }

    public String getVaccinationDetails() {
        return VaccinationDetails;
    }

    public void setVaccinationDetails(String vaccinationDetails) {
        VaccinationDetails = vaccinationDetails;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<PetImage> getImages() {
        return images;
    }

    public void setImages(List<PetImage> images) {
        this.images = images;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
