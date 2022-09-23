package com.example.yuldshop.model;


import com.example.yuldshop.model.DTO.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
@Accessors(chain = true)
public class Customer extends BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    private String email;

    @Column(unique = true, name = "phone")
    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private LocationRegion locationRegion;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", user=" + user +
                ", locationRegion=" + locationRegion +
                "} ";
    }

    public CustomerDTO customerDTO(LocationRegion locationRegion){
        return new CustomerDTO()
                .setId(id)
                .setEmail(email)
                .setFullName(fullName)
                .setPhone(phone)
                .setUser(user.toUserDTO())
                .setLocationRegion(locationRegion.locationRegionDTO());
    }
}
