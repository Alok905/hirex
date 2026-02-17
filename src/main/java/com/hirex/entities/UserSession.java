package com.hirex.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Table(name = "user_sessions")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @NotBlank
    String refreshToken;

    String deviceName;

    String ipAddress;

    String userAgent;

    @Column(nullable = false)
    Instant expiresAt;

    @Column(nullable = false)
    @Builder.Default
    boolean revoked = false;

    Instant lastUsedAt;

    @CreationTimestamp
    Instant createdAt;
}

