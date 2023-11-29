package com.example.studentmanagement.model.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class StudentCreationRequest {

    @NotBlank(message = "Tên sv bắt buộc nhập")
    private String name;

    @NotBlank(message = "địa chỉ bắt buộc nhập")
    private String address;


    @Length(max = 100, message = "so dien thoai không được vượt quá 100 ký tự")
    private String phone;





}
