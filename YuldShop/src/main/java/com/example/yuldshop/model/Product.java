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
    @Column(name = "product_name")
    private String productName;
    private String description;

    @Min(100)
    @Max(1000000000)
    private BigDecimal price;
  @Min(1)
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategory category;

    @Column(columnDefinition = "Varchar(1024) default 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYf_NT5oCBOdYJXDPpk4bQsmltVjofk0NpAg&usqp=CAU'")
    private String imgUrl;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imgUrl=" + imgUrl +
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
                .setImgUrl(imgUrl)
                .setQuantity(quantity);
    }
}
