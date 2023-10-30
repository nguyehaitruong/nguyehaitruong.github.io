package com.example.springmvc01.model.request;

import com.example.springmvc01.statics.PersonCategory;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Data
@Component
public class PersonCreationRequest {

    private int id;
    private String name;
    private String address;
    private LocalDate birth ;
    private List<PersonCategory> categories;
    private String gender  ;

}
