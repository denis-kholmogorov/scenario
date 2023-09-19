package com.example.springexample.services;
import com.example.springexample.dto.CommentDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class CommentCRUDService implements CRUDService<CommentDto> {

    @Value("${comment.length.max}")
    private Integer lengthMax;

    private final Map<Integer, CommentDto> storage = new HashMap<>();
    @Override
    public CommentDto getById(Integer id) {
        System.out.printf("Get by id = %s\n", id);
        return storage.get(id);
    }
    @Override
    public Collection<CommentDto> getAll() {
        System.out.println("Get all");
        return storage.values();
    }
    @Override
    public void create(CommentDto dto) {
        System.out.println("Create");
        if(dto.getText().length() > lengthMax){
            throw new RuntimeException("Размер текста комментария больше" + lengthMax);
        }
        int nextId = storage.size();
        dto.setId(nextId);
        storage.put(nextId, dto);
    }
    @Override
    public void update(CommentDto dto) {
        System.out.println("Update");
        if(dto.getText().length() > lengthMax){
            throw new RuntimeException("Размер текста комментария больше" + lengthMax);
        }

        CommentDto commentDto = storage.get(dto.getId());
        commentDto.setText(dto.getText());
    }
    @Override
    public CommentDto deleteById(Integer id) {
        System.out.println("Delete");
        return storage.remove(id);
    }}
