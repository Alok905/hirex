package com.hirex.entities;

import com.hirex.enums.roles.AppRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(unique = true, nullable = false)
    String email;

    @Column(unique = true, nullable = false)
    String username;

    @Column(nullable = false)
    String password;

    @Enumerated(EnumType.STRING)
    AppRole role;

    String profileImageUrl;

    @Column(nullable = false)
    @Builder.Default
    boolean isActive = true;

    @Column(nullable = false)
    boolean isVerified = false;

    @CreationTimestamp
    Instant createdAt;

    @UpdateTimestamp
    Instant updatedAt;

    Instant deletedAt; /// to soft-delete the user
}
