package com.example.jobseeker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "application_status_change")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationStatusChange extends BaseEntity{

    @Column(name = "change_id")
    Long changeId;

    @Column(name = "candidate_id")
    Long candidateId;

    @Column(name = "status_id")
    Long statusId;


}
