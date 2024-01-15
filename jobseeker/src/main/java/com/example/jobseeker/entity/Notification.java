package com.example.jobseeker.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "from_user_id", nullable = false)
    User fromUser;

    @Column(name = "to_user_id")
    Long toUserId;

    @Column(name = "title", length = 255)
    String title;

    @Column(name = "content", length = 255)
    String content;

    @Column(name = "[read]", length = 10)
    String read;
}
