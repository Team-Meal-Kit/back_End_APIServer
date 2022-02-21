package com.teammealkit.mealkit.client.role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserRole {
    ROLE_CLIENT("ROLE_CLIENT"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String value;
}
