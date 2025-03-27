package com.example.PetAdoption.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "pet_images")
public class PetImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(name="image_data", columnDefinition = "LONGBLOB",nullable= false)
    private  byte[] imageData;

    @ManyToOne
    @JoinColumn(name="pet_id",nullable = false)
    private PetEntity pet;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    public Integer getId() {
        return id;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public PetEntity getPet() {
        return pet;
    }
}
