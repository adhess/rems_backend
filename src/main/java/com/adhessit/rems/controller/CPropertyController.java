package com.adhessit.rems.controller;

import com.adhessit.rems.exception.REMSException;
import com.adhessit.rems.model.CProperty;
import com.adhessit.rems.service.CPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RestController
@RequestMapping("/property")
public class CPropertyController extends BaseController {

    @Autowired
    CPropertyService cPropertyService;

    @PostMapping("/post")
    public CProperty postProperty(@RequestBody CProperty property) throws REMSException {
        // property.setUserId(getCurrentUser().getUserId());
        CProperty savedProperty = checkNotNull(cPropertyService.saveProperty(property));
        // sendNotificationMsg(userId, savedPropertyId, created | updated)
        return savedProperty;
    }
}
