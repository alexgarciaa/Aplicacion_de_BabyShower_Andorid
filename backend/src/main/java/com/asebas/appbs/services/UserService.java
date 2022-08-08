package com.asebas.appbs.services;

import java.util.List;

import com.asebas.appbs.domain.User;
import com.asebas.appbs.exceptions.CAuthException;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;

public interface UserService {

    User validateUser(String email, String constraseña) throws CAuthException;

    User registerUser(String email, String contraseña, String telefono, String nombreUsuario) throws CAuthException;

    List<User> getAllUsers();

    User getUserById(Integer id) throws CResourceNotFoundException;

    void updateUser(Integer id, User user) throws CBadRequestException;

}
