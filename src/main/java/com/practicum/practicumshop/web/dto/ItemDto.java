package com.practicum.practicumshop.web.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@Data
public class ItemDto implements Serializable {
    List<Long> items;
}
