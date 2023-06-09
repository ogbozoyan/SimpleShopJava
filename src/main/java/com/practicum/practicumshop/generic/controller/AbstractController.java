package com.practicum.practicumshop.generic.controller;

import com.practicum.practicumshop.generic.dto.AbstractResponseDTO;
import com.practicum.practicumshop.generic.dto.specification.request.SearchRequest;
import com.practicum.practicumshop.generic.model.AbstractEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface AbstractController<T extends AbstractEntity> {
    @Operation(summary = "Получить постранично", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    ResponseEntity<AbstractResponseDTO> getPage(Pageable pageable);

    @Operation(summary = "Поиск по фильтрам", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("filter")
    ResponseEntity<AbstractResponseDTO> searchFilter(@RequestBody SearchRequest request);

    @Operation(summary = "Получить по id", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    ResponseEntity<T> getOne(@PathVariable Long id);

    @Operation(summary = "Обновить данные", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping
    ResponseEntity<T> update(@RequestBody T update);

    @Operation(summary = "Создать сущность", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    ResponseEntity<T> create(@RequestBody T create);

    @Operation(summary = "Удалить сущность по id", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    ResponseEntity<T> delete(@PathVariable Long id);
}
