package com.asebas.appbs.services;

import com.asebas.appbs.domain.Mother;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;

public interface MotherService {

    Mother getMotherById(Integer id) throws CResourceNotFoundException;

    Mother addMother(Integer userId, Mother madre) throws CBadRequestException;

    void updateMother(Integer id, Mother madre) throws CBadRequestException;

}
