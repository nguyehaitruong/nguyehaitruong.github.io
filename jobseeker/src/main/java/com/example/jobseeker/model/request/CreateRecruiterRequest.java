package com.example.jobseeker.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateRecruiterRequest {

    @NotBlank
    @Size(max = 50, message = "Email không được vượt quá 50 ký tự")
    private String email;

    @NotBlank
    @Size(max = 50, message = "Tên không được vượt quá 50 ký tự")
    private String name;

    @NotBlank
    private String companyname;

    @NotBlank
    private String address;

    @NotBlank
    private String password;

    @NotBlank
    @Size(max = 11, message = "Số điện thoại không được vượt quá 11 ký tự")
    private String phone;

    @NotBlank
    private String city;



}
