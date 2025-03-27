package com.example.PetAdoption.Controller;

import com.example.PetAdoption.Model.PetEntity;
import com.example.PetAdoption.Repository.PetRepository;
import com.example.PetAdoption.Services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pets")
@CrossOrigin(origins = "http://localhost:5173")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PetRepository petRepository;


    @GetMapping("/allPets")
    public List<PetEntity> getAllPets() {
        return petService.getAllPets();
    }
    @PostMapping("/add")
    public PetEntity addPet(@RequestBody PetEntity pet) {
        return petService.savePet(pet);
    }

    @PostMapping(value = "/{petId}/uploadImage" ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

    public ResponseEntity<String> uploadPetImage(@PathVariable Integer petId,
                                                 @RequestParam("file") MultipartFile file) throws IOException {
        petService.savePetImage(petId, file);
        return ResponseEntity.ok("Image uploaded successfully");
    }

    @GetMapping("/image/{imageId}")
    public ResponseEntity<byte[]> getPetImage(@PathVariable Integer imageId) {
        byte[] imageData = petService.getPetImage(imageId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);  // Change based on image type

        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }

}


