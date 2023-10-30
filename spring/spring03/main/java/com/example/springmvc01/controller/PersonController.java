package com.example.springmvc01.controller;

import com.example.springmvc01.entity.Person;
import com.example.springmvc01.model.request.PersonCreationRequest;
import com.example.springmvc01.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/persons")
    public String home(Model model) {
        List<Person> person = personService.getAll();
        model.addAttribute("dsSach", person);
        return "person";
    }

    @PostMapping("/create-person")
    public String createPerson(@ModelAttribute("sachMuonThemMoi") PersonCreationRequest person, Model model) {
        personService.createPerson(person);
        List<Person> people = personService.getAll(); // Sửa tên biến ở đây
        model.addAttribute("dsSach", people); // Sửa tên biến ở đây
        return "person";
    }


    @GetMapping("/delete-person/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model) {
        personService.createPerson(id);
        List<Person> people = personService.getAll();
        model.addAttribute("dsSach", people);
        return "person";
    }



    @PostMapping("/create-person")
    public String createPerson(@ModelAttribute("sachMuonThemMoi") PersonCreationRequest person, Model model) {
        personService.createPerson(person);
        List<Person> person = personService.getAll();
        model.addAttribute("dsSach", person);
        return "person";
    }

}
