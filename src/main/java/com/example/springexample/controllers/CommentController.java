package com.example.springexample.controllers;
import com.example.springexample.dto.CommentDto;
import com.example.springexample.services.CommentCRUDService;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
/**
 * CommentController
 */
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
    @PostMapping
    public void createComment(@RequestBody CommentDto commentDto) {
        commentService.create(commentDto);
    }
    @PutMapping
    public void updateComment(@RequestBody CommentDto commentDto) {
        commentService.update(commentDto);
    }
    @DeleteMapping("/{id}")
    public CommentDto deleteComment(@PathVariable Integer id) {
        return commentService.deleteById(id);
    }
}
