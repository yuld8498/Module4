package com.example.yuldshop.model;

import com.example.yuldshop.model.DTO.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Accessors(chain = true)
public class ProductCategory extends BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String category;

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                "} ";
    }
    public CategoryDTO toCategoryDTO(){
        return new CategoryDTO()
                .setId(id)
                .setCategory(category);
    }
}
