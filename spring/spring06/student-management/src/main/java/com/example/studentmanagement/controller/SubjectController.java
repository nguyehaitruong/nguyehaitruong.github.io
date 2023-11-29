package com.example.studentmanagement.controller;


import com.example.studentmanagement.model.request.StudentCreationRequest;
import com.example.studentmanagement.model.request.SubjectCreationRequest;
import com.example.studentmanagement.model.response.StudentResponse;
import com.example.studentmanagement.model.response.SubjectResponse;
import com.example.studentmanagement.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/subjects")
@AllArgsConstructor

public class SubjectController {
    private  final SubjectService subjectService;
    @GetMapping
    public String getsubjects(Model model){
        List<SubjectResponse> subjects=subjectService.getSubjects();
        model.addAttribute("dsmonhoc",subjects);
        return  "subjects";
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getSubjectDetals(@PathVariable Integer id){

        SubjectResponse subject= subjectService.getSubjectDetals(id);
        return  ResponseEntity.ok(subject);

    };
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable  int id){
        subjectService.delete(id);
        return   ResponseEntity.ok(null);

    } @PostMapping
    public ResponseEntity<?> createSubject(@RequestBody SubjectCreationRequest request){
        subjectService.createSubject(request);
        return ResponseEntity.ok(null);


    }
//    @PutMapping ("/{id}")
//    public ResponseEntity<?> updateStudent(@RequestBody SubjectCreationRequest request, @PathVariable Integer id){
//        studentService.updateStudent(id,request);
//        return ResponseEntity.ok(null);
//
//
//    }

}
