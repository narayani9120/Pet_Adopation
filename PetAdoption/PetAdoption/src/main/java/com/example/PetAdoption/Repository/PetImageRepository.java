package com.example.PetAdoption.Repository;

import com.example.PetAdoption.Model.PetImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetImageRepository extends JpaRepository<PetImage,Integer> {
}
