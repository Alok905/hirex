package com.hirex.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Table(name = "company_locations")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String officeName;

    private String city;
    private String country;

//    @Column(columnDefinition = "geography(Point, 4326)")
//    private Point location;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
}
