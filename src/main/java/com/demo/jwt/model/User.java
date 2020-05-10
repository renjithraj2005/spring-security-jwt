package com.demo.jwt.model;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails, CredentialsContainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;

    @Column(name = "is_superuser",nullable = false)
    private boolean isSuperuser;

    public User() {
    }

    public User(@Size(min = 4, max = 255, message = "Minimum username length: 4 characters") String username, String email, @Size(min = 8, message = "Minimum password length: 8 characters") String password, boolean isSuperuser) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isSuperuser = isSuperuser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        if (isSuperuser) {
            list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        } else {
            list.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return list;
    }

    public Role getRole(){
        return isSuperuser ? Role.ROLE_ADMIN : Role.ROLE_CLIENT;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void eraseCredentials() {
        password = null;
    }
}
