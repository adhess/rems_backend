package com.adhessit.rems.controller;

import com.adhessit.rems.model.Address;
import com.adhessit.rems.model.CProperty;
import com.adhessit.rems.model.UserInfo;
import com.adhessit.rems.security.CurrentUser;
import com.adhessit.rems.security.UserPrincipal;
import com.adhessit.rems.service.CPropertyService;
import com.adhessit.rems.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
public class CPropertyController extends BaseController {

    @Autowired
    CPropertyService cPropertyService;

    @PostMapping("/post")
    public CProperty postProperty(@RequestBody CProperty property, @CurrentUser UserPrincipal userPrincipal) throws Exception {
        // Todo: property.setUserId(getCurrentUser().getUserId());
        Address address = Utils.retrieveAddress(property.getLatitude(), property.getLongitude());
        property.setAddress(address);
        CProperty savedProperty = checkNotNull(cPropertyService.saveProperty(property, userPrincipal.getId()));
        // Todo: sendNotificationMsg(userId, savedPropertyId, created | updated)
        return savedProperty;
    }

    @GetMapping("/findAll")
    public List<CProperty> getProperties(@RequestParam int pageSize, @RequestParam int page) {
        // Todo: add PageLink {pageSize, page, searchText, sortOrder}
        return cPropertyService.findAllProperties();
    }

    @GetMapping("/findUserInfoByPropertyId")
    public UserInfo findUserInfoByPropertyId(@RequestParam Long propertyId) {
        return cPropertyService.findUserInfoByPropertyId(propertyId);
    }

    @GetMapping("/reset")
    public void reset() {
        cPropertyService.reset();
    }
}
