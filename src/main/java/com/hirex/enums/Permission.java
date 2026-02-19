package com.hirex.enums;

public enum Permission {

    USER_UPDATE,
    USER_DELETE,
    USER_APP_ROLE_UPDATE,

    /// COMPANY ADMIN
    USER_COMPANY_ROLE_UPDATE,

    COMPANY_CREATE,
    COMPANY_UPDATE,
    COMPANY_VIEW,
    COMPANY_DELETE,

    JOB_CREATE,
    JOB_UPDATE,
    JOB_DELETE,
    /// JOB_APPLY is not needed because anyone can apply for a job
    /// JOB_VIEW is not needed because anyone can view a job
    /// TODO: might add JOB_VIEW_PRIVATE if job creator will add screening questions for the job so that AI interviewer can ask the same regarding that context

    INTERVIEW_SCHEDULE,         // schedule interview
    INTERVIEW_UPDATE,
    INTERVIEW_CANCEL,
}
