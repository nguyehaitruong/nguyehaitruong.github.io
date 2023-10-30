package com.example.springmvc01.repository;

import com.example.springmvc01.entity.Person;
import com.example.springmvc01.model.request.PersonCreationRequest;
import com.example.springmvc01.statics.PersonCategory;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonRepository {

    private static final List<Person> persons = new ArrayList<>();

    private static int AUTO_ID = 1000;

    private final ObjectMapper objectMapper;

    static {

        for (int i = 0; i < 10; i++) {
//            Book book = new Book();
//            book.setId(i);
//            book.setName("Sách " + i);
//            book.setAuthor("Nguyễn Văn " + i);
//            book.setDescription("Mô tả thứ " + i);
//            book.setPublishedYear(i);
//            book.setCategories(Arrays.asList(BookCategory.KID));

            Person person = Person.builder()
                    .id(AUTO_ID++)
                    .name("Sách " + i)
                    .address("Nguyễn Văn " + i)
                    .gender("Mô tả thứ " + i)
                    .categories(Arrays.asList(PersonCategory.KID))
                    .birth(LocalDate.ofEpochDay(i))
                    .build();

            persons.add(person);
        }

    }

    public List<Person> getAll() {
        return person;
    }

    public void delete(int id) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId() == id) {
                persons.remove(i);
                return;
            }
        }
    }

    public void createPerson(PersonCreationRequest personCreationRequest) {
//        Book book = objectMapper.convertValue(bookCreationRequest, Book.class);
//        book.setId(AUTO_ID++);
        Person person = Person.builder()
                .id(AUTO_ID++)
                .name(personCreationRequest.getName())
                .address(personCreationRequest.getAddress())
                .gender(personCreationRequest.getGender())
                .birth(personCreationRequest.getBirth())
                .build();
        persons.add(person);

    }
}
