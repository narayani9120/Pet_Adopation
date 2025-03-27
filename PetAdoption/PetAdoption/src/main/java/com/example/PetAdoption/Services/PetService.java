      package com.example.PetAdoption.Services;

      import com.example.PetAdoption.Model.PetEntity;
      import com.example.PetAdoption.Model.PetImage;
      import org.springframework.web.multipart.MultipartFile;

      import java.io.IOException;
      import java.util.List;

      public interface PetService {



            PetImage savePetImage(Integer petId, MultipartFile file) throws IOException;

            byte[] getPetImage(Integer imageId);

            PetEntity savePet(PetEntity pet);

            List<PetEntity> getAllPets();
      }
