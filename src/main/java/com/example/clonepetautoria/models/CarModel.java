package com.example.clonepetautoria.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private int year;
    private int price;
    @Enumerated(value = EnumType.STRING)
    private Currency currency;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "car_images",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private List<ImagePath> imagesPath = new ArrayList<>(); //name of file

    public CarModel(String description, int year, int price, Currency currency) {
        this.description = description;
        this.year = year;
        this.price = price;
        this.currency = currency;
    }

    public void addImagePath(ImagePath imagePath) {
        this.imagesPath.add(imagePath);
    }
}
