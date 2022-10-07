package com.example.yuldshop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BasicEntity {
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createAt;

    @CreatedBy
    @Column(name = "created_by")
    private String createBy;

    @UpdateTimestamp
    @Column(name = "updated_at", insertable = false)
    private Date updateAt;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updateBy;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    @Override
    public String toString() {
        return "BasicEntity{" +
                "createAt=" + createAt +
                ", createBy='" + createBy + '\'' +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
