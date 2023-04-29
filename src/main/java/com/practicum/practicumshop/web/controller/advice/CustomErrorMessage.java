package com.practicum.practicumshop.web.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author ogbozoyan
 * @date 17.02.2023
 */
@Data
@AllArgsConstructor
public class CustomErrorMessage {
    private Integer statusCode;
    private Date timestamp;
    private String message;
    private String description;
}
