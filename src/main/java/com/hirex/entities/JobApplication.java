package com.hirex.entities;

import com.hirex.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Table(
        name = "job_applications",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"job_id", "candidate_id"})
        })
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    Job job;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "candidate_id", nullable = false)
    User candidate;

    /**
     * uploading new resume might cause create complexity.
     * because, here Resume means one entity that is being there in database.
     * for a particular resume for a job, we shouldn't add this.
     * instead of storing Resume entity, we should store the resume url.
     */
    String resumeUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ApplicationStatus status;

    @CreationTimestamp
    Instant appliedAt;

//    Instant lastStatusUpdate; // not required; it should come under ApplicationStatus only
}
