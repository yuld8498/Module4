package com.example.yuldshop.model.DTO;

import com.example.yuldshop.model.Product;
import com.example.yuldshop.model.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductDTO {
    @NotNull(message = "ID of product is not null")
    private Long id;
    @NotBlank(message = "product Name is not empty")
    @Length(min = 3, max = 20, message = "product Name have from 3 character to 20 character")
    private String productName;
    @NotBlank(message = "Product description is not empty")
    @Length(min = 10, max = 100, message = "product Name have from 10 character to 100 character")
    private String description;
    @NotNull(message = "quantity is not null")
    @Min(value = 1, message = "quantity is great than 0")
    @Max(value = 1000, message = "quantity is Less than or Equal 1000")
    private int quantity;
    @NotNull(message = "price is not null")
    @Min(value = 100, message = "price is great than 1000")
    @Max(value = 1000000000, message = "quantity is Less than or Equal 1 billion")
    private BigDecimal price;

    private String imgUrl;
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
                ", imgUrl=" + imgUrl +
                ", categoryDTO=" + category +
                '}';
    }

    public Product toProduct() {
        return new Product()
                .setId(id)
                .setProductName(productName)
                .setDescription(description)
                .setPrice(price)
                .setQuantity(quantity)
                .setImgUrl(imgUrl)
                .setCategory(category.toProductCategory());
    }
}
