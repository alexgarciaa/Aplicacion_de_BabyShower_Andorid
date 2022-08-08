package com.asebas.appbs.services;

import com.asebas.appbs.domain.Baby;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;

public interface BabyService {

    Baby getBabyById(Integer id) throws CResourceNotFoundException;

    Baby addBaby(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
            String fechaEstNac, String sexo, String padreEmail, String madreEmail) throws CBadRequestException;

    void updateBaby(Integer id, Baby baby) throws CBadRequestException;

}
