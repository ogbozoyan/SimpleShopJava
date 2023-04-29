package com.practicum.practicumshop.web.controller.advice;

import com.practicum.practicumshop.generic.controller.advice.AbstractException;
/**
 * @author ogbozoyan
 * @date 08.03.2023
 */
public class PageNotFoundException extends AbstractException {
    public PageNotFoundException(String msg) {
        super(msg);
    }
}
