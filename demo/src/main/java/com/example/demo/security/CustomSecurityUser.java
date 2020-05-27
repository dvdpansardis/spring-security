package com.example.demo.security;

import com.example.demo.domain.Authorities;
import com.example.demo.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;


public class CustomSecurityUser extends User implements UserDetails {

    public CustomSecurityUser(User user) {
        super(user.getId(), user.getUserName(), user.getPassword(), user.getAuthorities());
    }

    @Override
    public Set<Authorities> getAuthorities() {
        return super.getAuthorities();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
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
}
