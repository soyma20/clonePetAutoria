package com.example.clonepetautoria.services;

import com.example.clonepetautoria.dao.UserDAO;
import com.example.clonepetautoria.models.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserDAO userDAO;

    public List<UserModel> getUsers() {
        return userDAO.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userDAO.save(user);
    }

    public UserModel updateUser(UserModel user) {
        return userDAO.save(user);
    }

}
