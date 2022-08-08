package com.asebas.appbs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asebas.appbs.domain.Mother;
import com.asebas.appbs.domain.User;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;
import com.asebas.appbs.repositories.MotherRepository;
import com.asebas.appbs.repositories.UserRepository;

@Service
@Transactional
public class MotherServiceImpl implements MotherService {

    @Autowired
    private MotherRepository motherRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mother getMotherById(Integer id) throws CResourceNotFoundException {
        try {
            return motherRepository.findById(id).get();
        } catch (Exception e) {
            throw new CResourceNotFoundException("Resource not found");
        }
    }

    @Override
    public Mother addMother(Integer userId, Mother madre) throws CBadRequestException {
        try {
            User user = userRepository.findById(userId).get();
            madre.setUsuario(user);

            return motherRepository.save(madre);
        } catch (Exception e) {
            throw new CBadRequestException("Invalid data. Failed to create");
        }
    }

    @Override
    public void updateMother(Integer id, Mother madre) throws CBadRequestException {
        try {
            Mother existingMother = motherRepository.findById(id).get();

            existingMother.setPrimerNombre(madre.getPrimerNombre());
            existingMother.setSegundoNombre(madre.getSegundoNombre());
            existingMother.setPrimerApellido(madre.getPrimerApellido());
            existingMother.setSegundoApellido(madre.getSegundoApellido());
            existingMother.setFechaNac(madre.getFechaNac());
            existingMother.setTelefono(madre.getTelefono());
            existingMother.setEmail(madre.getEmail());

            motherRepository.save(existingMother);

        } catch (Exception e) {
            throw new CBadRequestException("Invalid data. Failed to update");
        }
    }

}
