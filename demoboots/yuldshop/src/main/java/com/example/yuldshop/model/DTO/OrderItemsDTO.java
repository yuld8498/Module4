package com.example.yuldshop.model.DTO;

import com.example.yuldshop.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderItemsDTO {
    private Long id;

    private int quantity;

    private String districtName;
    private String provinceName;
    private String wardName;
    private String address;

    private Long productId;
    private String productName;

    private Long orderId;
    private BigDecimal price;

    private Long idCustomer;
    private String customerName;

    @Override
    public String toString() {
        return "OrderItemsDTO{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", districName=" + districtName +
                ", provinceName=" + provinceName +
                ", wardName=" + wardName +
                ", address=" + address +
                ", productId=" + productId +
                ", productName=" + productName +
                ", orderId=" + orderId +
                ", idCustomer=" + idCustomer +
                ", price=" + price +
                ", customerName='" + customerName + '\'' +
                '}';
    }

    public OrderItemsDTO(Long id, int quantity, String districtName,
                         String provinceName, String wardName, String address,
                         Long productId, Long orderId, BigDecimal price,
                         Long idCustomer, String customerName) {
        this.id = id;
        this.quantity = quantity;
        this.districtName = districtName;
        this.provinceName = provinceName;
        this.wardName = wardName;
        this.address = address;
        this.productId = productId;
        this.orderId = orderId;
        this.price = price;
        this.idCustomer = idCustomer;
        this.customerName = customerName;
    }
}
