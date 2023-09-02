package com.example.springexample.services;

import com.example.springexample.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

/**
 * SubCommentCRUDService
 */
@Service
public class SubCommentCRUDService implements CRUDService<CommentDto> {

    private HashMap<Integer, CommentDto> storage = new HashMap<>();

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
        System.out.println("Delete");
        storage.put(dto.id, dto);
    }

    @Override
    public void update(CommentDto dto) {
        System.out.println("Update");
        CommentDto commentDto = storage.get(dto.id);
        commentDto.text = dto.text;
    }

    @Override
    public CommentDto deleteById(Integer id) {
        System.out.println("Update");
        return storage.remove(id);
    }
}
