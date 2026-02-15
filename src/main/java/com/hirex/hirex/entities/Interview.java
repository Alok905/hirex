package com.hirex.hirex.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Table(name = "interviews")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "job_application_id")
    JobApplication jobApplication;

    @Column(nullable = false)
    Instant startTime;

    @Column(nullable = false)
    Integer duration;

    String status;

    String interviewType;

    String meetingLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    User createdBy;

    @OneToMany(mappedBy = "interview")
    List<Interviewer> interviewers;
}
