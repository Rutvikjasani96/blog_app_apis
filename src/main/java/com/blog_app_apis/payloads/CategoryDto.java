package com.blog_app_apis.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private int categoryId;
    @NotEmpty(message = "Category title is Empty, Please fill it!")
    @Size(min = 4,max = 25,message = "Category title is 4 to 25 Characters.")
    private String categoryTitle;
    @NotEmpty(message = "Category description is Empty, Please fill it!")
    @Size(min = 10,max = 100,message = "Category Description is 10 to 100 Characters.")
    private String categoryDesc;
}
