package com.example.springexample.controllers;

import com.example.springexample.dto.AuthorDto;
import com.example.springexample.services.AuthorCRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorCRUDService authorService;

    @GetMapping("/{id}")
    public AuthorDto getById(@PathVariable Integer id) {
        return authorService.getById(id);
    }

    @GetMapping
    public Collection<AuthorDto> getAll() {
        return authorService.getAll();
    }

    @PostMapping
    public void create(@RequestBody AuthorDto authorDtoDto) {
        authorService.create(authorDtoDto);
    }

    @PutMapping
    public void update(@RequestBody AuthorDto authorDtoDto) {
        authorService.update(authorDtoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        authorService.deleteById(id);
    }

}
