package com.example.petshop.service;

import com.example.petshop.entity.Product;
import com.example.petshop.entity.Registration;
import com.example.petshop.exception.ProductNotFoundException;
import com.example.petshop.model.request.ProductCreationRequest;
import com.example.petshop.model.request.RegistrationCreationRequest;
import com.example.petshop.model.response.ProductResponse;
import com.example.petshop.model.response.RegistrationResponse;
import com.example.petshop.repository.RegistrationJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class RegistrationsService {
   private final RegistrationJpaRepository registrationJpaRepository;

    public List<RegistrationResponse> getRegistration() {
        List<RegistrationResponse> result = new ArrayList<>();
        List<Registration> registrations=registrationJpaRepository.findAll();
        for (int i = 0; i < registrations.size(); i++) {
            Registration registration = registrations.get(i);
            RegistrationResponse registrationResponse = RegistrationResponse.builder()
                    .id(registration.getId())
                    .name(registration.getName())
                    .phoneNumber(registration.getPhoneNumber())
                    .email(registration.getEmail())
                    .bookingContent(registration.getBookingContent())
                    .creationTime(registration.getCreationTime())
                    .approvalTime(registration.getApprovalRejectionTime())
                    .build();
            result.add(registrationResponse);
        }
        return result;
    }
    public RegistrationResponse getRegistrationDetails(Long id) throws ProductNotFoundException {
        Optional<Registration> registrationOptional = registrationJpaRepository.findById(id);
        if (registrationOptional.isEmpty()){
            throw  new ProductNotFoundException("student with id"+id+"could not found");
        }
        return  registrationJpaRepository.findById(id)
                .map(registration -> RegistrationResponse.builder()
                        .id(registration.getId())
                        .name(registration.getName())
                        .phoneNumber(registration.getPhoneNumber())
                        .email(registration.getEmail())
                        .bookingContent(registration.getBookingContent())
                        .creationTime(registration.getCreationTime())
                        .approvalTime(registration.getApprovalRejectionTime())
                        .build()
                )
                    .orElseThrow(()-> new ProductNotFoundException("student with id"+id+"could not found"));
    }
    public void createRegistrations(@Valid RegistrationCreationRequest registrationCreationRequest) {
        Registration registration = Registration.builder()

                .name(registrationCreationRequest.getName())
                .phoneNumber(registrationCreationRequest.getPhoneNumber())
                .email(registrationCreationRequest.getEmail())
                .bookingContent(registrationCreationRequest.getBookingContent())
                .status(registrationCreationRequest.getStatus())
                .creationTime(registrationCreationRequest.getCreationTime())
                .approvalRejectionTime(registrationCreationRequest.getApprovalRejectionTime())
                .build();

        registrationJpaRepository.save(registration);
    }
}
