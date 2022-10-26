package com.example.clonepetautoria.dao;

import com.example.clonepetautoria.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserModel, Integer> {
}
