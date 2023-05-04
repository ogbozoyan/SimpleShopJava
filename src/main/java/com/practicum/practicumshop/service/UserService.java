package com.practicum.practicumshop.service;

import com.practicum.practicumshop.configuration.security.jwt.CustomUserDetails;
import com.practicum.practicumshop.generic.service.AbstractServiceImpl;
import com.practicum.practicumshop.model.*;
import com.practicum.practicumshop.repository.*;
import com.practicum.practicumshop.web.controller.advice.FindException;
import com.practicum.practicumshop.web.dto.ItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@Service
public class UserService extends AbstractServiceImpl<UserEntity, UserEntityRepository> {
    private final PasswordEncoder passwordEncoder;
    private final RoleEntityRepository roleEntityRepository;
    private final ItemEntityRepository itemEntityRepository;
    private final CartRepository cartRepository;
    private final HistoryOrderEntityRepository historyOrderEntityRepository;

    @Autowired
    public UserService(UserEntityRepository repository, PasswordEncoder passwordEncoder, RoleEntityRepository roleEntityRepository, ItemEntityRepository itemEntityRepository,
                       CartRepository cartRepository, HistoryOrderEntityRepository historyOrderEntityRepository) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
        this.roleEntityRepository = roleEntityRepository;
        this.itemEntityRepository = itemEntityRepository;
        this.cartRepository = cartRepository;
        this.historyOrderEntityRepository = historyOrderEntityRepository;
    }

    @Transactional(readOnly = true)
    public UserEntity findByLogin(String username) {
        try {
            return repository.findByLogin(username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FindException("User Not Found with username: " + username);
        }
    }

    @Transactional
    public UserEntity signUp(UserEntity signUpDTO) {
        try {
            Set<RoleEntity> role = new HashSet<>();
            role.add(roleEntityRepository.findByName("ROLE_USER"));
            UserEntity user = repository.findByLogin(signUpDTO.getLogin());
            if (user != null) {
                throw new RuntimeException("Error: Username is already taken!");
            }
            user = new UserEntity();
            user.setLogin(signUpDTO.getLogin());
            user.setRoles(role);
            user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
            return repository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error: Role is not found.");
        }
    }

    @Transactional
    public List<CartEntity> createOrder(ItemDto itemDto) {
        try {
            UserEntity user = getCurrent();
            List<CartEntity> cart = new ArrayList<>();
            List<HistoryOrderEntity> orders = new ArrayList<>();
            for(Long item : itemDto.getItems()) {
                CartEntity cartEntity = new CartEntity();
                ItemEntity itemEntity = itemEntityRepository.findById(item).orElseThrow();
                cartEntity.setItem(itemEntity);
                cartEntity.setUser(user);
                cart.add(cartEntity);
            }
            cart = cartRepository.saveAllAndFlush(cart);

            for(CartEntity cartEntity : cart) {
                HistoryOrderEntity historyOrderEntity = new HistoryOrderEntity();
                historyOrderEntity.setUser(cartEntity.getUser());
                historyOrderEntity.setCart(cartEntity);
                orders.add(historyOrderEntity);
            }
            historyOrderEntityRepository.saveAllAndFlush(orders);

            return cart;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Transactional(readOnly = true)
    public UserEntity getCurrent() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            throw new Exception("UserService.getCurrentUser(): Ошибка получения аутентификационных данных");
        }
        Object principal = auth.getPrincipal();
        String userInfo;
        if (principal instanceof CustomUserDetails) {
            userInfo = ((CustomUserDetails) principal).getUsername();
            return findByLogin(userInfo);
        } else {
            throw new Exception("UserService.getCurrentUser(): Ошибка получения данных о пользователе");
        }
    }
}
