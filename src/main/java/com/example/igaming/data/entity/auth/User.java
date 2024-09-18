/**
 * @author: Riccardo_Bruno
 * @project: igaming-dice
 */


package com.example.igaming.data.entity.auth;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@NoArgsConstructor
@AllArgsConstructor
@Table( name = "app_user")
public class User {
    @Id
    private Long id;

    @Column("user_name")
    private String username;

    @Column("password")
    private String password;

    @Column("role")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

