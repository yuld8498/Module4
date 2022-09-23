package com.example.yuldshop.model.DTO;

import com.example.yuldshop.model.User;
import lombok.*;
import lombok.experimental.Accessors;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserDTO {

    private Long id;

    @NotBlank(message = "The user name is required")
    @Size(max = 50, message = "The length of email must be between 5 and 50 characters")
    private String username;

    @NotBlank(message = "The password is required")
    @Size(max = 30, message = "Maximum password length 30 characters")
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
