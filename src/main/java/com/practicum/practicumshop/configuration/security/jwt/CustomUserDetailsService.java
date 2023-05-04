package com.practicum.practicumshop.configuration.security.jwt;

import com.practicum.practicumshop.model.UserEntity;
import com.practicum.practicumshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    @Transactional
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserEntity user = userService.findByLogin(username);
            return CustomUserDetails.build(user);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
    }
}
