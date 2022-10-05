package com.example.th_module4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name", nullable = false)
    @Length(min = 1, max = 30)
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @NotNull(message = "area is not null")
    @Min(value = 1,message = "Area min value is 1")
    @Max(value = 2000000000, message = "Area max value is two billions")
    private BigDecimal area;

    @NotNull(message = "population is not null")
    @Min(1)
    @Max(100000000)
    private BigDecimal population;

    @NotNull(message = "GDP is not null")
    @Min(1)
    @Max(100000000)
    private BigDecimal GDP;

    @NotEmpty(message = "GDP is not null")
    @Length(min = 1, max = 200,message = "Description have from 1 to 200 character")
    private String description;
}
