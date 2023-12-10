package com.example.petshop.model.request;

import com.example.petshop.statics.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data

public class RegistrationCreationRequest {

    private Long id;

    @NotBlank(message = "Tên  bắt buộc nhập")
    private String name;

    @NotBlank(message = "sdt bắt buộc nhập")
    private String phoneNumber;

    @NotBlank(message = "email bắt buộc nhập")
    private String email;

    @NotBlank(message = "nội dung khám bắt buộc nhập")
    private String bookingContent;

    @NotBlank(message = "Tên sản phẩm bắt buộc nhập")
    private Status status;

    private LocalDateTime creationTime;

    private LocalDateTime approvalRejectionTime;
}
