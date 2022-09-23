package com.example.yuldshop.model;

import com.example.yuldshop.model.DTO.RoleDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
@Accessors(chain = true)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;

    @OneToMany(targetEntity = User.class, mappedBy = "role", fetch = FetchType.EAGER)
    private Set<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
    public RoleDTO toRoleDTO(){
        return new RoleDTO()
                .setId(id)
                .setCode(code)
                .setName(name);
    }
}
