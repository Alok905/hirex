package com.hirex.entities;

import com.hirex.enums.roles.CompanyMemberRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Table(
        name = "company_members",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"company_id", "user_id"}
        )
)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    Company company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    CompanyMemberRole memberRole;

    @CreationTimestamp
    Instant joinedAt;

//    /// we can store the inviter for admin role; will see later
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "invited_by")
//    User invitedBy;
}