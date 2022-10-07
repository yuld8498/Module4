package com.example.yuldshop.model.DTO;

import com.example.yuldshop.model.LocationRegion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class LocationRegionDTO {
    private Long id;

    @NotNull(message = "Province ID is empty")
    private Long provinceId;
    @NotEmpty(message = "Province Name is empty")
    private String provinceName;
    @NotNull(message = "district ID is empty")
    private Long districtId;
    @NotEmpty(message = "district Name is empty")
    private String districtName;
    @NotNull(message = "ward ID is empty")
    private Long wardId;
    @NotEmpty(message = "ward Name is empty")
    private String wardName;
    @NotBlank(message = "address  is empty")
    @Length(min = 3, max = 30, message ="Please enter no more than 30 characters" )
    private String address;

    @Override
    public String toString() {
        return "LocationRegionDTO{" +
                "id=" + id +
                ", provinceId=" + provinceId +
                ", provinceName='" + provinceName + '\'' +
                ", districtId=" + districtId +
                ", districtName='" + districtName + '\'' +
                ", wardId=" + wardId +
                ", wardName='" + wardName + '\'' +
                ", address=" + address +
                '}';
    }
    public LocationRegion toLocationRegion(){
        return new LocationRegion()
                .setId(id)
                .setProvinceId(provinceId)
                .setProvinceName(provinceName)
                .setDistrictId(districtId)
                .setDistrictName(districtName)
                .setWardId(wardId)
                .setWardName(wardName)
                .setAddress(address);
    }
}
