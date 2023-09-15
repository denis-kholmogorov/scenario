package com.example.springexample.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private Integer id;
    private String text;
    private LocalDateTime createDate;
    private Integer authorId;
    private String authorFirstName;
    private String authorLastName;
}
