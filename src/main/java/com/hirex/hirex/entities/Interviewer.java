package com.hirex.hirex.entities;

import com.hirex.hirex.enums.InterviewerType;
import jakarta.persistence.*;
import lombok.*;

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
public class Interviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_id")
    Interview interview;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    InterviewerType interviewerType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_interviewer_id")
    User interviewer; /// only if interviewType == AI; interviewer must be an employee

}
