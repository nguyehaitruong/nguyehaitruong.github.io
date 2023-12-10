package com.example.petshop.entity;

import com.example.petshop.statics.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Registration")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String phoneNumber;
    @Column
    private String email;
    @Column
    private String bookingContent;
    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column
    private LocalDateTime creationTime;
    @Column
    private LocalDateTime approvalRejectionTime;
}
