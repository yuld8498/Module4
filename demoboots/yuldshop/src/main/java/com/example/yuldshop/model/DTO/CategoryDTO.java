package com.example.yuldshop.model.DTO;

import com.example.yuldshop.model.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CategoryDTO {
    private Long id;
    @NotEmpty(message = "category Name is not empty!")
    private String category;

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
    public ProductCategory toProductCategory(){
        return new ProductCategory()
                .setId(id)
                .setCategory(category);
    }
}
