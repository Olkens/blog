package com.olkens.blog.services.impl;

import com.olkens.blog.domain.entities.Category;
import com.olkens.blog.repositories.CategoryRepository;
import com.olkens.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }
}
