package com.example.petshop.model.response;

import com.example.petshop.statics.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationResponse {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String bookingContent;
    private Status status;
    private LocalDateTime creationTime;
    private LocalDateTime approvalTime;

}
