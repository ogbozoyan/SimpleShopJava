package com.practicum.practicumshop.repository;

import com.practicum.practicumshop.generic.repository.AbstractRepository;
import com.practicum.practicumshop.model.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@Repository
public interface UserEntityRepository extends AbstractRepository<UserEntity> {
    UserEntity findByLogin(String username);
}
