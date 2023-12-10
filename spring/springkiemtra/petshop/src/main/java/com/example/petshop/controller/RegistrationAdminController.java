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
@RequestMapping("/registration-admin")
@AllArgsConstructor
public class RegistrationAdminController {
    private final RegistrationsService registrationsService;

    @GetMapping
    public String getRegistration(Model model){
        List<RegistrationResponse> registration=registrationsService.getRegistration();
        model.addAttribute("dsDangky",registration);
        return  "registration-admin";
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getRegistrationDetails(@PathVariable Long id) throws ProductNotFoundException {

        RegistrationResponse registration= registrationsService.getRegistrationDetails(id);
        return  ResponseEntity.ok(registration);

    };


}
