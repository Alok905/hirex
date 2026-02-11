package com.hirex.hirex.enums;

import lombok.Getter;

import java.util.EnumSet;
import java.util.Set;

@Getter  // for "getPermissions()" method
public enum Role {
    /**
     * Super admin of the entire application.
     * Gets ALL permissions automatically.
     */
    APPLICATION_ADMIN(EnumSet.allOf(Permission.class)),

    /**
     * Admin of a specific company only. all these access are specific to the company they belong to
     */
    COMPANY_ADMIN(Set.of(
            Permission.COMPANY_CREATE,
            Permission.COMPANY_VIEW,
            Permission.COMPANY_UPDATE,
            Permission.COMPANY_DELETE,

            Permission.JOB_CREATE,
            Permission.JOB_UPDATE,
            Permission.JOB_DELETE,

            Permission.INTERVIEW_SCHEDULE,
            Permission.INTERVIEW_UPDATE,
            Permission.INTERVIEW_CANCEL
    )),

    USER(Set.of());

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
