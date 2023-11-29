package com.example.studentmanagement.model.request;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
public class StudentUpdateRequest {
    @NotNull(message = "id bắt buộc nhập")
    private int id;

    @NotBlank(message = "Tên học sinh bắt buộc nhập")
    @Length(max = 100, message = "Tên sách không được vượt quá 100 ký tự")
    private String name;

    @NotBlank(message = "Tên tác giả bắt buộc nhập")
    @Length(max = 100, message = "Tên tác giả không được vượt quá 100 ký tự")
    private String address;

    @NotBlank(message = "năm xuất bản bắt buộc")
    @Min(value = 1990, message = "Thư viện của tao nói không với sách cũ")
    private String phone;




}
