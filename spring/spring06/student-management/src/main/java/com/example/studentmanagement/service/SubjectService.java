package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.entity.Subject;
import com.example.studentmanagement.model.request.StudentCreationRequest;
import com.example.studentmanagement.model.request.SubjectCreationRequest;
import com.example.studentmanagement.model.response.StudentResponse;
import com.example.studentmanagement.model.response.SubjectResponse;
import com.example.studentmanagement.repository.StudentRepository;
import com.example.studentmanagement.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor

public class SubjectService {
    private SubjectRepository subjectRepository;

    public List<SubjectResponse> getSubjects() {
        List<Subject> subjects = subjectRepository.getSubject();
        List<SubjectResponse> result = new ArrayList<>();
        for (int i = 0; i < subjects.size(); i++) {
            Subject subject = subjects.get(i);
            SubjectResponse subjectResponse = SubjectResponse.builder()
                    .id(subject.getId())
                    .name(subject.getName())
                    .credit(subject.getCredit())
                    .subjectType(subject.getSubjectType())

                    .build();
            result.add(subjectResponse);
        }
        return result;
    }
    public SubjectResponse getSubjectDetals(Integer id) {
        List<Subject> subjects = subjectRepository.getSubject();

        for (int i=0;i<subjects.size();i++){
            if (subjects.get(i).getId()==id){
                Subject subject=subjects.get(i);
                return SubjectResponse.builder()
                        .id(subject.getId())
                        .name(subject.getName())
                        .credit(subject.getCredit())
                        .subjectType(subject.getSubjectType())
                        .build();

            }

        }
        return  null;

    }
    public void delete(int id)  {
        List<Subject> subjects = subjectRepository.getSubject();
        List<Subject> result=new ArrayList<>();
        for (int i=0;i<subjects.size();i++){
            if (subjects.get(i).getId()==id){
                continue;
            }
            result.add((subjects.get(i)));
        }
        subjectRepository.save(subjects);


    }
    public List<Subject> createSubject(@Valid SubjectCreationRequest subjectCreationRequest) {
        Subject subject = Subject.builder()
                .id(StudentRepository.AUTO_ID++)
                .name(subjectCreationRequest.getName())
                .credit(subjectCreationRequest.getCredit())
                .subjectType(subjectCreationRequest.getSubjectType())
                .build();
        return subjectRepository.createSubject(subject);
    }

}
