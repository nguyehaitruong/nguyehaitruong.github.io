package com.example.jobseeker.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.Date;

@Entity
@Table(name = "curriculum_vitaes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurriculumVitae extends  BaseEntity{



    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "name", length = 255)
    String name;

    @Column(name = "cv_url", length = 255)
    String cvUrl;


}
