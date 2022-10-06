package com.example.yuldshop.model.DTO;

import com.example.yuldshop.model.CartItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ListCartItemsDTO {
    private Long id;
    @NotNull(message = "productId is not empty !")
    private Long productId;
    @NotEmpty(message = "Product Name is not Empty")
    private String productName;
    @NotNull(message = "price is not null")
    @Min(value = 1)
    private BigDecimal price;
    @NotNull(message = "quantity is not null")
    @Min(value = 1, message = "Quantity is great than zero !")
    @Max(value = 999, message = "Quantity is less than 1000")
    private int quantity;
    @NotNull(message = "amount is not null")
    @Min(value = 1)
    private BigDecimal amount;

    private String imgUrl;

    private boolean checked;

    @Override
    public String toString() {
        return "ListCartItemsDTO{" +
                "id=" + id +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", imgUrl=" + imgUrl +
                ", checked=" + checked +
                '}';
    }

    public CartItem toCartItem(){
        return new CartItem()
                .setId(id)
                .setProductName(productName)
                .setProductId(productId)
                .setAmount(amount)
                .setQuantity(quantity)
                .setPrice(price)
                .setChecked(checked)
                .setImgUrl(imgUrl);
    }
}
