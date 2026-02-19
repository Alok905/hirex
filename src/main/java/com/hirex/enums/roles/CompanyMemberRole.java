package com.hirex.enums.roles;

import com.hirex.enums.Permission;
import lombok.Getter;

import java.util.Set;

@Getter  // for "getPermissions()" method
public enum CompanyMemberRole {
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
            Permission.INTERVIEW_CANCEL,

            Permission.USER_COMPANY_ROLE_UPDATE /// specific to company like employee/admin; not user/
    )),

    EMPLOYEE(Set.of());

    private final Set<Permission> permissions;

    CompanyMemberRole(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}

