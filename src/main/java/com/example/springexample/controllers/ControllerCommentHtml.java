package com.example.springexample.controllers;

import com.example.springexample.dto.CommentDto;
import com.example.springexample.services.CommentCRUDService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Deprecated
@Controller
public class ControllerCommentHtml {

    CommentCRUDService service;

    public ControllerCommentHtml(CommentCRUDService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public String showAddCommentForm(Model model) {
        model.addAttribute("comment", new CommentDto());
        return "add-comment";
    }

    @PostMapping("/add")
    public String addComment(CommentDto comment) {
        service.create(comment);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String showComments(Model model) {
        model.addAttribute("comments", service.getAll());
        return "list-comments";
    }



}
