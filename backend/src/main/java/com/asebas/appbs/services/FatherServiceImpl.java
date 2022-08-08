package com.asebas.appbs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asebas.appbs.domain.Father;
import com.asebas.appbs.domain.User;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;
import com.asebas.appbs.repositories.FatherRepository;
import com.asebas.appbs.repositories.UserRepository;

@Service
@Transactional
public class FatherServiceImpl implements FatherService {

    @Autowired
    private FatherRepository fatherRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Father getFatherById(Integer id) throws CResourceNotFoundException {
        try {
            return fatherRepository.findById(id).get();
        } catch (Exception e) {
            throw new CResourceNotFoundException("Resource not found");
        }
    }

    @Override
    public Father addFather(Integer userId, Father padre) throws CBadRequestException {
        try {
            User user = userRepository.findById(userId).get();
            padre.setUsuario(user);

            return fatherRepository.save(padre);
        } catch (Exception e) {
            throw new CBadRequestException("Invalid data. Failed to create");
        }
    }

    @Override
    public void updateFather(Integer id, Father padre) throws CBadRequestException {
        try {
            Father existingFather = fatherRepository.findById(id).get();

            existingFather.setPrimerNombre(padre.getPrimerNombre());
            existingFather.setSegundoNombre(padre.getSegundoNombre());
            existingFather.setPrimerApellido(padre.getPrimerApellido());
            existingFather.setSegundoApellido(padre.getSegundoApellido());
            existingFather.setFechaNac(padre.getFechaNac());
            existingFather.setTelefono(padre.getTelefono());
            existingFather.setEmail(padre.getEmail());

            fatherRepository.save(existingFather);
        } catch (Exception e) {
            throw new CBadRequestException("Invalid data. Failed to update");
        }
    }

}
