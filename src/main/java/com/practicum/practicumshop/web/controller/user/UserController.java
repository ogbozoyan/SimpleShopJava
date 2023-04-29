package com.practicum.practicumshop.web.controller.user;

import com.practicum.practicumshop.generic.controller.AbstractControllerImpl;
import com.practicum.practicumshop.model.UserEntity;
import com.practicum.practicumshop.service.UserService;
import com.practicum.practicumshop.web.dto.ItemDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
@Slf4j
public class UserController extends AbstractControllerImpl<UserEntity, UserService> {
    private final UserService service;
    public UserController(UserService service) {
        super(service);
        this.service = service;
    }
    @PostMapping("/createOrder")
    @Operation(summary = "создать заказ", security = @SecurityRequirement(name = "bearerAuth"))
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public UserEntity createOrder(ItemDto dto){
        return service.createOrder(dto);
    }
    @GetMapping("/getCurrent")
    @Operation(summary = "получить текущего юзера", security = @SecurityRequirement(name = "bearerAuth"))
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public UserEntity getCurrent() throws Exception {
        return service.getCurrent();
    }
}
