package com.olkens.blog.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {

    @Size(min = 1, max = 50, message = "Category name must be between {min} and {max} characters long")
    @NotBlank(message="Category name is required")
    @Pattern(regexp = "^[\\w\\s-]+$", message = "Category name can only contain characters")
    private String name;

}
