package com.asebas.appbs.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asebas.appbs.domain.User;
import com.asebas.appbs.exceptions.CAuthException;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;
import com.asebas.appbs.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User validateUser(String email, String contraseña) throws CAuthException {
        try {
            User user = userRepository.findByEmail(email);

            if (!BCrypt.checkpw(contraseña, user.getContraseña())) {
                throw new CAuthException("Invalid email/password");
            }

            return user;
        } catch (Exception e) {
            throw new CAuthException("Invalid email/password");
        }
    }

    @Override
    public User registerUser(String email, String contraseña, String telefono, String nombreUsuario)
            throws CAuthException {
        try {
            User existingUser = userRepository.findByEmail(email);

            if (existingUser != null)
                throw new CAuthException("Email is already in use");

            String hashedPassword = BCrypt.hashpw(contraseña, BCrypt.gensalt(10));

            User user = new User(email, hashedPassword, telefono, nombreUsuario);

            return userRepository.save(user);
        } catch (Exception e) {
            throw new CAuthException("Invalid data. Failed to register");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) throws CResourceNotFoundException {
        try {
            return userRepository.findById(id).get();
        } catch (Exception e) {
            throw new CResourceNotFoundException("Resource not found");
        }
    }

    @Override
    public void updateUser(Integer id, User user) throws CBadRequestException {
        try {
            User existingUser = userRepository.findById(id).get();

            existingUser.setTelefono(user.getTelefono());
            existingUser.setNombreUsuario(user.getNombreUsuario());

            userRepository.save(existingUser);

        } catch (Exception e) {
            throw new CBadRequestException("Invalid data. Failed to update");
        }
    }

}
