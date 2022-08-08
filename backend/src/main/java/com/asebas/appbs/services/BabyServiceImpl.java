package com.asebas.appbs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asebas.appbs.domain.Baby;
import com.asebas.appbs.domain.Father;
import com.asebas.appbs.domain.Mother;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;
import com.asebas.appbs.repositories.BabyRepository;
import com.asebas.appbs.repositories.FatherRepository;
import com.asebas.appbs.repositories.MotherRepository;

@Service
@Transactional
public class BabyServiceImpl implements BabyService {

    @Autowired
    private BabyRepository babyRepository;

    @Autowired
    private FatherRepository fatherRepository;

    @Autowired
    private MotherRepository motherRepository;

    @Override
    public Baby getBabyById(Integer id) throws CResourceNotFoundException {
        try {
            return babyRepository.findById(id).get();
        } catch (Exception e) {
            throw new CResourceNotFoundException("Resource not found");
        }
    }

    @Override
    public Baby addBaby(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
            String fechaEstNac, String sexo, String padreEmail, String madreEmail) throws CBadRequestException {
        try {
            Father padre = fatherRepository.findByEmail(padreEmail);
            Mother madre = motherRepository.findByEmail(madreEmail);

            Baby baby = new Baby(primerNombre, segundoNombre, primerApellido, segundoApellido, fechaEstNac, sexo, padre,
                    madre);

            return babyRepository.save(baby);

        } catch (Exception e) {
            throw new CBadRequestException("Invalid data. Failed to create");
        }
    }

    @Override
    public void updateBaby(Integer id, Baby baby) throws CBadRequestException {
        try {
            Baby existingBaby = babyRepository.findById(id).get();

            existingBaby.setPrimerNombre(baby.getPrimerNombre());
            existingBaby.setSegundoNombre(baby.getSegundoNombre());
            existingBaby.setPrimerApellido(baby.getPrimerApellido());
            existingBaby.setSegundoNombre(baby.getSegundoApellido());
            existingBaby.setFechaEstNac(baby.getFechaEstNac());
            existingBaby.setSexo(baby.getSexo());

            babyRepository.save(existingBaby);
        } catch (Exception e) {
            throw new CBadRequestException("Invalid data. Failed to update");
        }
    }

}
