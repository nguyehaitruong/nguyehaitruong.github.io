package com.example.springmvc01.service;

import com.example.springmvc01.entity.Person;
import com.example.springmvc01.model.request.PersonCreationRequest;
import com.example.springmvc01.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getAll() {
        return personRepository.getAll();
    }

    public void deleteBook(int id) {
        personRepository.delete(id);
    }

    public void createPerson(PersonCreationRequest personCreationRequest) {
        personRepository.createPerson(personCreationRequest);
    }

}
