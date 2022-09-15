package com.codegym.mavenbankingajax.model;

import com.codegym.mavenbankingajax.model.dto.CustomerDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true)
public class Customer extends BasicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @NotNull
    private String phone;

    @Column(precision = 12, scale = 0, updatable = false)
    private BigDecimal balance;

    @NotNull
    @Email
    private String email;
    private  String address;

    @OneToMany(mappedBy = "customer")
    private Set<Deposit> deposits;

    @OneToMany(mappedBy = "customer")
    private Set<Withdraw> withdraws;

    @OneToMany(mappedBy = "sender")
    private Set<Transfer> sender;

    @OneToMany(mappedBy = "recipient")
    private Set<Transfer> recipient;


    public CustomerDTO toCustomerDTO(){
        return  new CustomerDTO()
                .setId(id)
                .setFullName(fullName)
                .setPhone(phone)
                .setBalance(balance.toString())
                .setEmail(email)
                .setAddress(address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                "} " + super.toString();
    }

}
