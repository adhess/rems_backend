package com.adhessit.rems.service;

import com.adhessit.rems.model.CProperty;
import com.adhessit.rems.repository.CPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CPropertyService {

    @Autowired
    CPropertyRepository cPropertyRepository;

    public CProperty saveProperty(CProperty cProperty) {
        return cPropertyRepository.save(cProperty);
    }
}
