package com.teammealkit.mealkit.client.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

@RequiredArgsConstructor
@Getter
public class MyClientDetails implements UserDetails {
    @Delegate
    private final Client client;
    private final Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return client.getEmail();
    }

    @Override
    public String getPassword() {
        return client.getPw();
    }

    @Override
    public boolean isAccountNonExpired() {
        return client.getIsEnable();
    }

    @Override
    public boolean isAccountNonLocked() {
        return client.getIsEnable();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return client.getIsEnable();
    }

    @Override
    public boolean isEnabled() {
        return client.getIsEnable();
    }
}
