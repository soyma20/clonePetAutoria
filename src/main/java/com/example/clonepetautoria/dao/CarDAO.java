package com.example.clonepetautoria.dao;

import com.example.clonepetautoria.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDAO extends JpaRepository<CarModel, Integer> {
}
