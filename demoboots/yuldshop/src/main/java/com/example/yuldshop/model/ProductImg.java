package com.example.yuldshop.model;

import com.example.yuldshop.model.DTO.ImgDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Arrays;


@Getter
@Setter
@AllArgsConstructor
public class ProductImg {

    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private String type;

    @Lob
    @Column(name = "img_data", length = 1000)
    private byte[] imgData;

    @Override
    public String toString() {
        return "ProductImg{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product=" + product +
                ", type='" + type + '\'' +
                ", imgData=" + Arrays.toString(imgData) +
                '}';
    }

    public ImgDTO toImgDTO(){
        return new ImgDTO()
                .setId(id)
                .setName(name);
    }
}
