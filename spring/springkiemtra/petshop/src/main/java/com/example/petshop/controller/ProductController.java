package com.example.petshop.controller;

import com.example.petshop.exception.ProductNotFoundException;
import com.example.petshop.model.request.ProductCreationRequest;
import com.example.petshop.model.response.ProductResponse;
import com.example.petshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public String getProduct(Model model){
        List<ProductResponse> product=productService.getProduct();
        model.addAttribute("dsSanpham",product);
        return  "product";
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductDetails(@PathVariable Long id) throws ProductNotFoundException {

        ProductResponse product= productService.getProductDetails(id);
        return  ResponseEntity.ok(product);

    };




}
