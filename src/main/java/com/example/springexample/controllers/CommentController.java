package com.example.springexample.controllers;
import com.example.springexample.dto.CommentDto;
import com.example.springexample.services.CommentCRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentCRUDService commentService;

    public CommentController(CommentCRUDService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public CommentDto getCommentById(@PathVariable Integer id) {
        return commentService.getById(id);
    }
    @GetMapping
    public Collection<CommentDto> getAllComments() {
        return commentService.getAll();
    }
    @GetMapping("/page")
    public Page<CommentDto> getAllCommentsPage(Pageable page) {
        return commentService.getAllPage(page);
    }
    @PostMapping
    public void createComment(@RequestBody CommentDto commentDto) {
        commentService.create(commentDto);
    }
    @PutMapping
    public void updateComment(@RequestBody CommentDto commentDto) {
        commentService.update(commentDto);
    }
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Integer id) {
        commentService.deleteById(id);
    }
}
