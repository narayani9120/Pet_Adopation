package com.example.PetAdoption.Repository;

import com.example.PetAdoption.Model.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetEntity,Integer> {
}
