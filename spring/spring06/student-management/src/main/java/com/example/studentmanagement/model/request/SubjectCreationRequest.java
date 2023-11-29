package com.example.studentmanagement.model.request;

import com.example.studentmanagement.statics.SubjectType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class SubjectCreationRequest {

    @NotBlank(message = "Tên sv bắt buộc nhập")
    private String name;

    @NotBlank(message = "địa chỉ bắt buộc nhập")
    private int credit;

    @NotBlank(message = "địa chỉ bắt buộc nhập")
    private SubjectType subjectType;;





}
