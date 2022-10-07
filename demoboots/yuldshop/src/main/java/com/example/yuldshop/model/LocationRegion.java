package com.example.yuldshop.model;

import com.example.yuldshop.model.DTO.LocationRegionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "location_Regions")
@Accessors(chain = true)
public class LocationRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "province_id")
    private Long provinceId;
    @Column(name = "province_name")
    private String provinceName;
    @Column(name = "district_id")
    private Long districtId;
    @Column(name = "district_name")
    private String districtName;
    @Column(name = "ward_id")
    private Long wardId;
    @Column(name = "ward_name")
    private String wardName;

    private String address;

    @Override
    public String toString() {
        return "LocationRegion{" +
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
    public LocationRegionDTO locationRegionDTO(){
        return new LocationRegionDTO()
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
