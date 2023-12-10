package com.example.petshop.controller;

import com.example.petshop.exception.ProductNotFoundException;
import com.example.petshop.model.request.RegistrationCreationRequest;
import com.example.petshop.model.response.RegistrationResponse;
import com.example.petshop.service.RegistrationsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Registration-form")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationsService registrationsService;

    @GetMapping
    public String getRegistration(Model model){

        return  "Registration-form";
    }

    @PostMapping
    public ResponseEntity<?> createRegistration(@RequestBody RegistrationCreationRequest request){
        registrationsService.createRegistrations(request);
        return ResponseEntity.ok(null);

    }
}
