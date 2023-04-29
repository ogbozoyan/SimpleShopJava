package com.practicum.practicumshop.model;

import com.practicum.practicumshop.generic.model.AbstractEntity;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class ItemEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Integer price;

}