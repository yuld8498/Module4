package com.example.yuldshop.model;

import com.example.yuldshop.model.DTO.ListCartItemsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "cart_items")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true)
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_id")
    private Long productId;

    private String productName;

    @Column(precision = 9, scale = 0, nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int quantity;

    @Column(precision = 9, scale = 0, nullable = false, columnDefinition = "Big decimal default 0")
    private BigDecimal amount;

    @Column(name = "imgUrl", length = 1024)
    private String imgUrl;

    @Column(name = "checked", columnDefinition = "boolean default false")
    private boolean checked;
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
    private Cart cart;

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", cart=" + cart +
                ", imgUrl=" + imgUrl +
                '}';
    }

    public ListCartItemsDTO toCartDTO() {
        return new ListCartItemsDTO()
                .setId(id)
                .setProductName(productName)
                .setPrice(price)
                .setQuantity(quantity)
                .setAmount(amount)
                .setChecked(checked)
                .setProductId(productId)
                .setImgUrl(imgUrl);
    }
}
