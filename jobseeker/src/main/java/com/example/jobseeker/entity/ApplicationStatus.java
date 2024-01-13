package com.example.jobseeker.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;



@Entity
@Table(name = "application_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationStatus {

    @Id
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    ApplicationStatus applicationStatus;

}
