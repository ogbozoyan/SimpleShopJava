package com.practicum.practicumshop.service;

import com.practicum.practicumshop.generic.service.AbstractServiceImpl;
import com.practicum.practicumshop.model.ItemEntity;
import com.practicum.practicumshop.repository.ItemEntityRepository;
import org.springframework.stereotype.Service;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@Service
public class ItemService extends AbstractServiceImpl<ItemEntity, ItemEntityRepository> {
    public ItemService(ItemEntityRepository repository) {
        super(repository);
    }
}
