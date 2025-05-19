package com.olkens.blog.services.impl;

import com.olkens.blog.domain.entities.Category;
import com.olkens.blog.repositories.CategoryRepository;
import com.olkens.blog.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        String categoryName = category.getName();

        if (categoryRepository.existsByNameIgnoreCase(categoryName)) {
            throw new IllegalArgumentException("Category name already exists :: ${categoryName} ::");
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            if(!category.get().getPosts().isEmpty()){
                throw new IllegalStateException("Category has posts associated with it");
            }
            categoryRepository.deleteById(id);
        }
    }
}
