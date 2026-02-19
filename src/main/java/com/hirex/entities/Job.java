package com.hirex.entities;

import com.hirex.enums.Currency;
import com.hirex.enums.EmploymentType;
import com.hirex.enums.JobStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

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

    @Column(nullable = false, columnDefinition = "text")
    String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    JobStatus status;

//    String location; /// will see later

    @Column(nullable = false)
    EmploymentType employmentType;

    Long minSalary;
    Long maxSalary;
    Currency currency;

    @CreationTimestamp
    Instant postedAt;

    Instant expiresAt;
}
