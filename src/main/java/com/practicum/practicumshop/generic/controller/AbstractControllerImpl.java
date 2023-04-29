package com.practicum.practicumshop.generic.controller;

import com.practicum.practicumshop.generic.dto.AbstractResponseDTO;
import com.practicum.practicumshop.generic.dto.specification.request.SearchRequest;
import com.practicum.practicumshop.generic.model.AbstractEntity;
import com.practicum.practicumshop.generic.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
public abstract class AbstractControllerImpl<E extends AbstractEntity, S extends AbstractService<E>>
        implements AbstractController<E> {

    protected final AbstractService<E> service;

    @Override
    public ResponseEntity<AbstractResponseDTO> getPage(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @Override
    public ResponseEntity<E> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<AbstractResponseDTO> searchFilter(@RequestBody SearchRequest request) {
        return ResponseEntity.ok(service.searchFilter(request));
    }

    @Override
    public ResponseEntity<E> update(@RequestBody E update) {
        return ResponseEntity.ok(service.update(update));
    }

    @Override
    public ResponseEntity<E> create(@RequestBody E create) {
        return ResponseEntity.ok(service.save(create));
    }

    @Override
    public ResponseEntity<E> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}