package com.example.yuldshop.model.DTO;

import com.example.yuldshop.model.Product;
import com.example.yuldshop.model.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductDTO {
    @NotNull(message = "ID of product is not null")
    private Long id;
    @NotEmpty(message = "product Name is not empty")
    private String productName;
    @NotEmpty(message = "Product description is not empty")
    private String description;
    @NotNull(message = "quantity is not null")
    @Min(value = 1, message = "quantity is great than 0")
    @Max(value = 1000, message = "quantity is Less than or Equal 1000")
    private int quantity;
    @NotNull(message = "price is not null")
    @Min(value = 1000, message = "price is great than 1000")
    @Max(value = 1000000000, message = "quantity is Less than or Equal 1 billion")
    private BigDecimal price;
    @Valid
    private CategoryDTO category;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", categoryDTO=" + category +
                '}';
    }
    public Product toProduct(){
        return new Product()
                .setId(id)
                .setProductName(productName)
                .setDescription(description)
                .setPrice(price)
                .setQuantity(quantity)
                .setCategory(category.toProductCategory());
    }
}
