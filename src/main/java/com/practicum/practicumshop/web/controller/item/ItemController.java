package com.practicum.practicumshop.web.controller.item;

import com.practicum.practicumshop.generic.controller.AbstractControllerImpl;
import com.practicum.practicumshop.generic.service.AbstractService;
import com.practicum.practicumshop.model.ItemEntity;
import com.practicum.practicumshop.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/item")
@Slf4j
public class ItemController extends AbstractControllerImpl<ItemEntity, ItemService> {
    public ItemController(AbstractService<ItemEntity> service) {
        super(service);
    }
}
