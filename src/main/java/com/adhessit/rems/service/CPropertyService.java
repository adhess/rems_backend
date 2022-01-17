package com.adhessit.rems.service;

import com.adhessit.rems.model.CProperty;
import com.adhessit.rems.model.User;
import com.adhessit.rems.model.UserInfo;
import com.adhessit.rems.repository.CPropertyRepository;
import com.adhessit.rems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CPropertyService {

    @Autowired
    CPropertyRepository cPropertyRepository;

    @Autowired
    UserRepository userRepository;

    public CProperty saveProperty(CProperty cProperty, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        assert user.isPresent() : "user id not found exception";
        cProperty.setUser(user.get());
        return cPropertyRepository.save(cProperty);
    }

    public List<CProperty> findAllProperties() {
        return cPropertyRepository.findAll();
    }

    public void reset() {
        cPropertyRepository.deleteAll();
    }

    public UserInfo findUserInfoByPropertyId(Long propertyId) {
        CProperty property = cPropertyRepository.getById(propertyId);
        User user = property.getUser();
        return new UserInfo(user.getName(), user.getPhoneNumber(), user.getImageUrl());
    }
}
