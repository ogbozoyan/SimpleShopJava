package com.practicum.practicumshop.repository;

import com.practicum.practicumshop.generic.repository.AbstractRepository;
import com.practicum.practicumshop.model.RoleEntity;
import org.springframework.stereotype.Repository;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@Repository
public interface RoleEntityRepository extends AbstractRepository<RoleEntity> {
    RoleEntity findByName(String roleUser);
}
