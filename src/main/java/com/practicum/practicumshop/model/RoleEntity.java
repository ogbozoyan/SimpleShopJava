package com.practicum.practicumshop.model;

import com.practicum.practicumshop.generic.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role_table")
public class RoleEntity extends AbstractEntity {
    private String name;
}
