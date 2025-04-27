package com.olkens.blog.services;

import com.olkens.blog.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
}
