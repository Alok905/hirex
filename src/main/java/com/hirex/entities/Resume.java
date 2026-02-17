package com.hirex.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Table(name = "resumes")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    User user;

    @Column(nullable = false)
    String fileUrl;

    Long fileSize;

    String fileType;

    /**
     * we'll parse the resume with AI and will keep the response like this;
     * <resume>
     *     <experiences>
     *         <experience>
     *             <company>company name</title>
     *             <role>company role</role>
     *             <start_year>start year</start_year>
     *             <end_year>end year</end_year>    /// null if current company
     *             <description>
     *                 .... description of the experience
     *             </description>
     *             <skills>
     *                 .... skills that was used (tech stacks)
     *             </skills>
     *         </experience>
     *     </experiences>
     *     <projects>
     *         ....
     *     </projects>
     *     <educations>
     *         ...
     *     </educations>
     * </resume>
     */
    @Column(nullable = false)
    String parseStatus;

    String embeddingId;

    @CreationTimestamp
    Instant uploadedAt;
}
