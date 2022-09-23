package com.example.yuldshop.model;

import com.example.yuldshop.model.DTO.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Accessors(chain = true)
public class Product extends BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String productName;
    private String description;

    @Min(0)
    @Max(1000000000)
    private BigDecimal price;
    @Column(columnDefinition = "Integer default 0")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategory category;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category=" + category +
                "} ";
    }

    public ProductDTO toProductDTO() {
        return new ProductDTO()
                .setId(id)
                .setDescription(description)
                .setProductName(productName)
                .setCategory(category.toCategoryDTO())
                .setPrice(price)
                .setQuantity(quantity);
    }
}
