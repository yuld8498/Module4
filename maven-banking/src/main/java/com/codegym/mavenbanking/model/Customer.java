package com.codegym.mavenbanking.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The Full Name is required")
    private String fullName;

    @NotEmpty(message = "The phone number is required.")
    @Column(unique = true, nullable = false)
    private String phone;

    @NotEmpty(message = "The address is required")
    private String address;

    @Digits(integer =  9, fraction = 0)
    @Column(updatable = false)
    private BigDecimal balance;

    @NotEmpty(message = "The email address is required.")
    @Email(message = "The email address is invalid.")
    @Size(min = 5, max = 50, message = "The length of email must be between 5 and 50 characters.")
    @Column(unique = true, nullable = false)
    private String email;

}
