package com.practicum.practicumshop.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@Data
public class LoginDTO implements Serializable {
    private String login;
    private String password;
}

