package com.olkens.blog.controllers;

import com.olkens.blog.domain.dtos.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path ="/api/v1/categories")
@RequiredArgsConstructor
public class CategoryRESTController {

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> listCategories() {

    }
}
