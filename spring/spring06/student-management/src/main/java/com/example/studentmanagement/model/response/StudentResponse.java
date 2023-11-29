package com.example.studentmanagement.model.response;

import com.example.studentmanagement.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {


        private  int id;
        private  String name;
        private  String address;
        private  String phone;
        private String className;



}
