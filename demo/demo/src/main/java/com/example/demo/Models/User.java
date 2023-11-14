package com.example.demo.Models;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String username;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(length = 11)
    private String phone;
    @Enumerated(EnumType.STRING)
    private UserStatus UserStatus;
    @OneToOne(optional = true)
    private Address address;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
        // throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
        // throw new UnsupportedOperationException("Unimplemented method 'isAccountNonExpired'");
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
        // throw new UnsupportedOperationException("Unimplemented method 'isAccountNonLocked'");
    
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
        // throw new UnsupportedOperationException("Unimplemented method 'isCredentialsNonExpired'");
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
        // throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
    }
    @Override
    public String getUsername(){
        return this.email;
    }
}
