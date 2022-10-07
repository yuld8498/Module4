package com.example.yuldshop.model.DTO;

import com.example.yuldshop.model.User;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserDTO {

    private Long id;

    @NotBlank(message = "The user name is required")
    @Length(min = 5,max = 30,message = "The length of username must be between 5 and 30 characters")
    private String username;

    @NotBlank(message = "The password is required")
    @Length(min = 8,max = 30,message = "The length of password must be between 5 and 30 characters")
    @Pattern(regexp = "^([a-zA-Z0-9])(?=.*[\\W]).{8,}$",
            message = "Password must have at least 8 characters, including at least 1 uppercase character, 1 lowercase character, number and special character")
    private String password;

    @Valid
    private RoleDTO role;

    public UserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public User toUser() {
        return new User()
                .setId(id)
                .setUsername(username)
                .setPassword(password)
                .setRole(role.toRole());
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
