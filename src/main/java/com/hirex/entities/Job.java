package com.hirex.entities;

import com.hirex.enums.JobStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Table(name = "jobs")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_owner", nullable = false)
    User jobOwner;

    /// no need to write company here; user (jobOwner) already belongs to a company
    /// single source of truth

    @Column(nullable = false)
    String title;

    @Column(nullable = false, length = 4000)
    String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    JobStatus status;
}
