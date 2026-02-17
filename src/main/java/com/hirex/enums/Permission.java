package com.hirex.enums;

public enum Permission {

//    USER_VIEW not required; anyone can see other's profile to know about them
    USER_UPDATE,
    USER_DELETE,
    USER_ROLE_UPDATE, /// employee -> company admin

    COMPANY_CREATE,
    COMPANY_UPDATE,   /// it also includes assign admins
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
