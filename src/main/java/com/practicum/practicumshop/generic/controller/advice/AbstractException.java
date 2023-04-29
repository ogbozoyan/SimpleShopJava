package com.practicum.practicumshop.generic.controller.advice;

import lombok.Data;

import java.io.Serial;

/**
 * @author ogbozoyan
 * @date 17.02.2023
 */
@Data
public class AbstractException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public AbstractException(String msg){
        super(msg);
    }
}
