package com.example.yuldshop.repository;

import com.example.yuldshop.model.DTO.OrderItemsDTO;
import com.example.yuldshop.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderItemsRepository extends JpaRepository<OrderItems, Long> {
    @Query("SELECT new com.example.yuldshop.model.DTO.OrderItemsDTO(o.id," +
            "o.quantity," +
            "o.order.customer.locationRegion.districtName," +
            "o.order.customer.locationRegion.provinceName," +
            "o.order.customer.locationRegion.wardName," +
            "o.order.customer.locationRegion.address," +
            "o.productId," +
            "o.order.id," +
            "o.order.total," +
            "o.order.customer.id," +
            "o.order.customer.fullName) " +
            "from OrderItems  AS o WHERE o.order.id = ?1")
    List<OrderItemsDTO> findAllOrderDTOByOrderId(Long id);

    @Query("SELECT new com.example.yuldshop.model.DTO.OrderItemsDTO(o.id," +
            "o.quantity," +
            "o.order.customer.locationRegion.districtName," +
            "o.order.customer.locationRegion.provinceName," +
            "o.order.customer.locationRegion.wardName," +
            "o.order.customer.locationRegion.address," +
            "o.productId," +
            "o.order.id," +
            "o.price," +
            "o.order.customer.id," +
            "o.order.customer.fullName) " +
            "from OrderItems  AS o")
    List<OrderItemsDTO> findAllOrderDTO();
}
