package com.adhessit.rems.model;

import lombok.Data;

@Data
public class UserInfo {
    String name;
    Integer phoneNumber;
    String imgUrl;

    public UserInfo(String name, Integer phoneNumber, String imgUrl) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.imgUrl = imgUrl;
    }
}
