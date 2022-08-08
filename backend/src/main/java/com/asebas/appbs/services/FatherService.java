package com.asebas.appbs.services;

import com.asebas.appbs.domain.Father;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;

public interface FatherService {

    Father getFatherById(Integer id) throws CResourceNotFoundException;

    Father addFather(Integer userId, Father padre) throws CBadRequestException;

    void updateFather(Integer id, Father padre) throws CBadRequestException;

    // void deleteFather(Integer id) throws CResourceNotFoundException;

}
