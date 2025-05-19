package com.olkens.blog.mappers;

import com.olkens.blog.domain.PostStatus;
import com.olkens.blog.domain.dtos.CategoryDTO;
import com.olkens.blog.domain.dtos.CreateCategoryRequest;
import com.olkens.blog.domain.entities.Category;
import com.olkens.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDTO toDto(Category category);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (null == posts) {
            return 0;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }

    Category toEntity(CreateCategoryRequest createCategoryRequest);
}
