package com.example.clonepetautoria.services;

import com.example.clonepetautoria.dao.CarDAO;
import com.example.clonepetautoria.models.dto.CarResponseDTO;
import com.example.clonepetautoria.models.CarModel;
import com.example.clonepetautoria.models.ImagePath;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {
    private CarDAO carDAO;

    public List<CarResponseDTO> getAll() {
        return carDAO.findAll().stream().map(CarResponseDTO::new).collect(Collectors.toList());
    }

    public CarResponseDTO getById(Integer id) {
        return carDAO.findById(id).map(CarResponseDTO::new).get();
    }

    public void createCar(String description, Integer year, Integer price, List<MultipartFile> files) throws IOException {
        CarModel car = new CarModel(description, year, price);
        for (MultipartFile file : files) {
            file.transferTo(new File(System.getProperty("user.home") + File.separator + "newfiles" + File.separator + file.getOriginalFilename()));
            car.addImagePath(new ImagePath(file.getOriginalFilename()));
        }
        carDAO.save(car);
    }

    public void updateCar(CarModel carModel) {
        carDAO.save(carModel);
    }

    public void deleteCar(Integer id) {
        carDAO.deleteById(id);
    }

    public void addImage(Integer id, MultipartFile file) throws IOException {

        CarModel carModel = carDAO.findById(id).get();
        file.transferTo(new File(System.getProperty("user.home") + File.separator + "newfiles" + File.separator + file.getOriginalFilename()));
        carModel.addImagePath(new ImagePath(file.getOriginalFilename()));
        carDAO.save(carModel);
    }
}
