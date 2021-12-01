package com.adhessit.rems.controller;

import com.adhessit.rems.exception.ResourceNotFoundException;
import com.adhessit.rems.model.User;
import com.adhessit.rems.repository.UserRepository;
import com.adhessit.rems.security.CurrentUser;
import com.adhessit.rems.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                "User",
                                "id",
                                userPrincipal.getId()
                        )
                );
    }
}
