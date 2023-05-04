package com.practicum.practicumshop.repository;

import com.practicum.practicumshop.generic.repository.AbstractRepository;
import com.practicum.practicumshop.model.CartEntity;
import org.springframework.stereotype.Repository;

/**
 * @author ogbozoyan
 * @date 04.05.2023
 */
@Repository
public interface CartRepository extends AbstractRepository<CartEntity> {
}
