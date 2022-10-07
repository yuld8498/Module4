package com.example.yuldshop.model.DTO;

import com.example.yuldshop.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CustomerDTO {
    private Long id;

    @NotBlank(message = "Full Name is not empty")
    @Length(min = 3, message = "Full Name great than 3 character")
    private String fullName;
    @NotEmpty(message = "Email is required")
    @Email(message = "Email is not valid")
    @Length(min = 5, max = 30, message = "Full Name great than 5 character and less than 30 character")
    private String email;
    @Column(unique = true)
    @Length(min = 5, max = 30, message = "Full Name great than 5 character and less than 30 character")
    private String phone;

    private UserDTO user;
    @Valid
    private LocationRegionDTO locationRegion;

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userDTO=" + user +
                ", locationRegion=" + locationRegion +
                '}';
    }

    public Customer toCustomer(LocationRegionDTO locationRegionDTO){
        return new Customer()
                .setId(id)
                .setEmail(email)
                .setFullName(fullName)
                .setPhone(phone)
                .setUser(user.toUser())
                .setLocationRegion(locationRegionDTO.toLocationRegion());
    }
}
