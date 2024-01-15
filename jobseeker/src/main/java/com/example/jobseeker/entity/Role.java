package com.example.jobseeker.entity;

import javax.persistence.*;

import com.example.jobseeker.statics.Roles;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", length = 255)
    @Enumerated(EnumType.STRING)
    Roles name;

    @Column(name = "description", length = 255)
    String description;

}
