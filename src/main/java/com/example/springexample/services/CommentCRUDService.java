package com.example.springexample.services;
import com.example.springexample.dto.CommentDto;
import com.example.springexample.entity.Author;
import com.example.springexample.entity.Comment;
import com.example.springexample.repositories.AuthorRepository;
import com.example.springexample.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;


@Service
@Transactional
@RequiredArgsConstructor
public class CommentCRUDService implements CRUDService<CommentDto> {

    @Value("${comment.length.max}")
    private Integer lengthMax;

    private final CommentRepository commentRepository;

    private final AuthorRepository authorRepository;

    @Override
    public CommentDto getById(Integer id) {
        System.out.printf("Get by id = %s\n", id);
        Comment comment = commentRepository.findById(id).orElseThrow();
        return mapToDto(comment);
    }
    @Override
    public Collection<CommentDto> getAll() {
        System.out.println("Get all");
        return commentRepository.findAll().stream().map(CommentCRUDService::mapToDto).toList();
    }

    public Page<CommentDto> getAllPage(Pageable page) {
        System.out.println("Get all");
        return commentRepository.findAll(page).map(CommentCRUDService::mapToDto);
    }
    @Override
    public void create(CommentDto dto) {
        System.out.println("Create");
        if(dto.getText().length() > lengthMax){
            throw new RuntimeException("Размер текста комментария больше" + lengthMax);
        }

        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow();
        Comment comment = mapToEntity(dto);
        comment.setAuthor(author);
        commentRepository.save(comment);
    }
    @Override
    public void update(CommentDto dto) {
        System.out.println("Update");
        if(dto.getText().length() > lengthMax){
            throw new RuntimeException("Размер текста комментария больше" + lengthMax);
        }
        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow();
        Comment comment = mapToEntity(dto);
        comment.setAuthor(author);
        commentRepository.save(comment);
    }
    @Override
    public CommentDto deleteById(Integer id) {
        System.out.println("Delete");
        Comment comment = commentRepository.findById(id).orElseThrow();
        commentRepository.deleteById(id);
        return mapToDto(comment);
    }

    public static CommentDto mapToDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setText(comment.getText());
        commentDto.setCreateDate(comment.getCreatedDate());
        commentDto.setAuthorId(comment.getAuthor().getId());
        commentDto.setAuthorFirstName(comment.getAuthor().getFirstName());
        commentDto.setAuthorLastName(comment.getAuthor().getLastName());
        return commentDto;
    }

    public static Comment mapToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setText(commentDto.getText());
        return comment;
    }
}



