package com.hirex.enums.roles;

import com.hirex.enums.Permission;

import java.util.EnumSet;
import java.util.Set;

public enum AppRole {
    /**
     * Super admin of the entire application.
     * Gets ALL permissions automatically.
     */
    ADMIN(EnumSet.allOf(Permission.class)),

    USER(Set.of(
            Permission.COMPANY_CREATE
    ));

    private final Set<Permission> permissions;

    AppRole(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
