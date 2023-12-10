package com.example.petshop.service;

import com.example.petshop.entity.Product;
import com.example.petshop.exception.ProductNotFoundException;
import com.example.petshop.model.request.ProductCreationRequest;
import com.example.petshop.model.response.ProductResponse;
import com.example.petshop.repository.ProductJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ProductService {
    private  final ProductJpaRepository productJpaRepository;

    public List<ProductResponse> getProduct() {
        List<ProductResponse> result = new ArrayList<>();
        List<Product> products=productJpaRepository.findAll();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            ProductResponse productResponse = ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .image(product.getImage())
                    .build();
            result.add(productResponse);
        }
        return result;
    }
    public ProductResponse getProductDetails(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productJpaRepository.findById(id);
        if (productOptional.isEmpty()){
            throw  new ProductNotFoundException("student with id"+id+"could not found");
        }
        return  productJpaRepository.findById(id)
                .map(product -> ProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .image(product.getImage())
                        .build()
                )
                .orElseThrow(()-> new ProductNotFoundException("student with id"+id+"could not found"));
    }
    public void createProduct(@Valid ProductCreationRequest productCreationRequest) {
        Product product = Product.builder()

                .name(productCreationRequest.getName())
                .price(productCreationRequest.getPrice())
                .description(productCreationRequest.getDescription())
                .image(productCreationRequest.getImage())
                .build();

        productJpaRepository.save(product);
    }
    public void  updateProduct(Long id, ProductCreationRequest request) throws ProductNotFoundException {
        Optional<Product> productOptional = productJpaRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("student with id" + id + "could not found");

        }
        Product product = productOptional.get();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDescription(request.getDescription());
        product.setImage(request.getImage());

        productJpaRepository.save(product);
    }

}
