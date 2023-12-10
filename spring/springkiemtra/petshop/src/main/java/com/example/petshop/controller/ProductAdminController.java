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
@RequestMapping("/product-admin")
@AllArgsConstructor
public class ProductAdminController {
    private final ProductService productService;
    @GetMapping
    public String getProduct(Model model){
        List<ProductResponse> product=productService.getProduct();
        model.addAttribute("dsSanpham",product);
        return  "product-admin";
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductDetails(@PathVariable Long id) throws ProductNotFoundException {

        ProductResponse product= productService.getProductDetails(id);
        return  ResponseEntity.ok(product);

    };
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductCreationRequest request){
        productService.createProduct(request);
        return ResponseEntity.ok(null);

    }
    @PutMapping ("/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductCreationRequest request, @PathVariable Long id) throws ProductNotFoundException {
        productService.updateProduct(id,request);
        return ResponseEntity.ok(null);


    }



}
