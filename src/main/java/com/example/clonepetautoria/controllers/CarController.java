package com.example.clonepetautoria.controllers;


import com.example.clonepetautoria.dao.CarDAO;
import com.example.clonepetautoria.models.dto.CarResponseDTO;
import com.example.clonepetautoria.models.CarModel;
import com.example.clonepetautoria.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {
    private CarDAO carDAO;
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<CarResponseDTO>> getAll() {
        return new ResponseEntity<>(carService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDTO> getById(@PathVariable Integer id){
        return new ResponseEntity<>(carService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void create(@RequestParam String description,
                       @RequestParam Integer year,
                       @RequestParam Integer price,
                       @RequestParam List<MultipartFile> files) throws IOException {
        carService.createCar(description, year, price, files);
    }
    @PatchMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody CarModel carModel){
        carService.updateCar(carModel);
    }
    @PatchMapping("/{id}")
    public void addImage(@PathVariable Integer id, @RequestParam MultipartFile file) throws IOException {
        carService.addImage(id, file);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Integer id){
        carService.deleteCar(id);
    }

}
