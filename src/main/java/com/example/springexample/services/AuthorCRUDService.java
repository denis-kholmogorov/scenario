package com.example.springexample.services;

import com.example.springexample.dto.AuthorDto;
import com.example.springexample.entity.Author;
import com.example.springexample.entity.Comment;
import com.example.springexample.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorCRUDService implements CRUDService<AuthorDto> {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorDto getById(Integer id) {
        log.info("Get by id = {}", id);
        Author author = authorRepository.findById(id).orElseThrow();
        return mapToDto(author);
    }

    @Override
    public Collection<AuthorDto> getAll() {
        log.info("Get all");
        return authorRepository.findAll().stream().map(AuthorCRUDService::mapToDto).toList();
    }

    @Override
    public void create(AuthorDto dto) {
        log.info("Create");
        authorRepository.save(mapToEntity(dto));
    }

    @Override
    public void update(AuthorDto dto) {
        log.info("Update");
        authorRepository.save(mapToEntity(dto));

    }

    @Override
    public AuthorDto deleteById(Integer id) {
        log.info("Delete");
        Author author = authorRepository.findById(id).orElseThrow();
        authorRepository.deleteById(id);
        return mapToDto(author);
    }

    public static Author mapToEntity(AuthorDto dto){
        Author author = new Author();
        author.setId(dto.getId());
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        author.setRating(dto.getRating());
        return author;
    }

    public static AuthorDto mapToDto(Author author){
        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLastName());
        dto.setRating(author.getRating());
        dto.setComments(author.getComments().stream().map(CommentCRUDService::mapToDto).toList());
        return dto;
    }
}



