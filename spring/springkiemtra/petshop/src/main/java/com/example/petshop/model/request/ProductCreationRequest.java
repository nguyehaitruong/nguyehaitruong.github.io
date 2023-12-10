package com.example.petshop.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data

public class ProductCreationRequest {

    private Long id;

    @NotBlank(message = "Tên sản phẩm bắt buộc nhập")
    private  String name;

    @NotBlank(message = "đơn giá bắt buộc nhập")
    private String price;

    @NotBlank(message = "mô tả bắt buộc nhập")
    private String description;


    @NotBlank(message = "nhâập hình ảnh")
    private String image;

}
