package com.example.springexample;

import com.example.springexample.dto.AuthorDto;
import com.example.springexample.entity.Author;
import com.example.springexample.repositories.AuthorRepository;
import com.example.springexample.services.AuthorCRUDService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AuthorCRUDServiceTest {

    private final AuthorRepository authorRepository = Mockito.mock(AuthorRepository.class);
    private final AuthorCRUDService authorCRUDService = new AuthorCRUDService(authorRepository);

    @Test
    void testGetById() {

        int authorId = 1;
        Author author = new Author();
        author.setId(authorId);
        author.setComments(List.of());
        when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));

        AuthorDto authorDto = authorCRUDService.getById(authorId);

        assertEquals(authorId, authorDto.getId());
        verify(authorRepository, times(1)).findById(authorId);
    }

    @Test
    void testGetAll() {

        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setId(1);
        author.setComments(List.of());
        authors.add(author);
        when(authorRepository.findAll()).thenReturn(authors);


        Collection<AuthorDto> authorDtos = authorCRUDService.getAll();


        assertEquals(authors.size(), authorDtos.size());
        verify(authorRepository, times(1)).findAll();
    }

    @Test
    void testCreate() {

        AuthorDto authorDto = new AuthorDto();

        authorCRUDService.create(authorDto);

        verify(authorRepository, times(1)).save(any(Author.class));
    }

    @Test
    void testUpdate() {

        AuthorDto authorDto = new AuthorDto();

        authorCRUDService.update(authorDto);

        verify(authorRepository, times(1)).save(any(Author.class));
    }

    @Test
    void testDeleteById() {

        int authorId = 1;
        Author author = new Author();
        author.setId(authorId);
        author.setComments(List.of());
        when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));

        AuthorDto authorDto = authorCRUDService.deleteById(authorId);

        assertEquals(authorId, authorDto.getId());
        verify(authorRepository, times(1)).findById(authorId);
        verify(authorRepository, times(1)).deleteById(authorId);
    }
}
