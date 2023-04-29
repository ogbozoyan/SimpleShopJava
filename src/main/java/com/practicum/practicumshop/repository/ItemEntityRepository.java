package com.practicum.practicumshop.repository;

import com.practicum.practicumshop.generic.repository.AbstractRepository;
import com.practicum.practicumshop.model.ItemEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemEntityRepository extends AbstractRepository<ItemEntity> {
}