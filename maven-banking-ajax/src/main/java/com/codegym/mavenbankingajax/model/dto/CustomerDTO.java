package com.codegym.mavenbankingajax.model.dto;

import com.codegym.mavenbankingajax.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CustomerDTO {
    private Long id;
    private String fullName;
    private String phone;
    private String  balance;
    private String email;
    private  String address;

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                    ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public Customer toCustomer(){
        return  new Customer()
                .setId(id)
                .setAddress(address)
                .setBalance(new BigDecimal(Long.parseLong(balance)))
                .setPhone(phone)
                .setEmail(email)
                .setFullName(fullName);
    }
}
