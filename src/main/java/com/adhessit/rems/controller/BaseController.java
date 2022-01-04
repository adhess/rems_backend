package com.adhessit.rems.controller;

import com.adhessit.rems.exception.REMSException;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseController {
    <T> T checkNotNull(T reference) throws REMSException {
        return checkNotNull(reference, "Requested item was not found");
    }

    <T> T checkNotNull(T reference, String notFoundMessage) throws REMSException {
        if (reference == null) {
            throw new REMSException(notFoundMessage);
        }
        return reference;
    }
}
