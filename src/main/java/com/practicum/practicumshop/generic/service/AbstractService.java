package com.practicum.practicumshop.generic.service;

import com.practicum.practicumshop.generic.dto.AbstractResponseDTO;
import com.practicum.practicumshop.generic.dto.specification.request.SearchRequest;
import com.practicum.practicumshop.generic.model.AbstractEntity;
import org.springframework.data.domain.Pageable;

public interface AbstractService<T extends AbstractEntity> {
    T save(T entity);

    T update(T entity);

    T delete(Long id);

    T findById(Long id);

    AbstractResponseDTO findAll(Pageable pageable);

    AbstractResponseDTO searchFilter(SearchRequest request);
}