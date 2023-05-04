package com.practicum.practicumshop.model;

import com.practicum.practicumshop.generic.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * @author ogbozoyan
 * @date 29.04.2023
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class UserEntity extends AbstractEntity {

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @OneToMany
    @JoinTable
            (
                    name = "user_role",
                    joinColumns = @JoinColumn(name = "user_id"),
                    inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    private Set<RoleEntity> roles;

}

