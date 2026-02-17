package com.hirex.entities;

import com.hirex.enums.InterviewerType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Table(
        name = "interviewers",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_interviewer",
                        columnNames = {"job_id", "candidate_id", "interviewer_id", "interviewer_type"}
                )
        }
)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Interviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_id")
    Interview interview;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    InterviewerType interviewerType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_interviewer_id")
    User interviewer; /// only if interviewType == AI; interviewer must be an employee

    String role;

    @Column(columnDefinition = "TEXT")
    String aiConfigJson;
}
