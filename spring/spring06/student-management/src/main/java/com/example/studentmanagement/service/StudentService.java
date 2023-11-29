package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.model.request.StudentCreationRequest;
import com.example.studentmanagement.model.response.StudentResponse;
import com.example.studentmanagement.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentResponse> getStudents() {
        List<Student> students = studentRepository.getStudents();
        List<StudentResponse> result = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            StudentResponse studentResponse = StudentResponse.builder()
                    .id(student.getId())
                    .name(student.getName())
                    .address(student.getAddress())
                    .phone(student.getPhone())
                    .className(student.getClassName())
                    .build();
            result.add(studentResponse);
        }
        return result;
    }
//    public List<Student> deleteStudent(int id)  {
//
//        return studentRepository.delete(id);
//    }
    public void delete(int id)  {
        List<Student> students = studentRepository.getStudents();
        List<Student> result=new ArrayList<>();
        for (int i=0;i<students.size();i++){
            if (students.get(i).getId()==id){
                continue;
            }
            result.add((students.get(i)));
        }
        studentRepository.save(result);


    }

    public List<Student> createStudent(@Valid StudentCreationRequest studentCreationRequest) {
        Student student = Student.builder()
                .id(StudentRepository.AUTO_ID++)
                .name(studentCreationRequest.getName())
                .address(studentCreationRequest.getAddress())
                .phone(studentCreationRequest.getPhone())
                .build();
        return studentRepository.createStudent(student);
    }

//    public StudentResponse findById(int id)  {
//        Student student = studentRepository.findById(id);
//        return StudentResponse.builder()
//                .id(student.getId())
//                .name(student.getName())
//                .address(student.getAddress())
//                .phone(student.getPhone())
//                .build();
//    }

    public void  updateStudent(Integer id, StudentCreationRequest request)  {
        List<Student> students = studentRepository.getStudents();
        for (int i=0;i<students.size();i++){
            if (students.get(i).getId()==id)
                 {
                    students.get(i).setName(request.getName());
                    students.get(i).setAddress(request.getAddress());
                    students.get(i).setPhone(request.getPhone());
                    break;
            }

        }
        studentRepository.save(students);


    }
    public StudentResponse getStudentDetails(Integer id) {
        List<Student> students = studentRepository.getStudents();

        for (int i=0;i<students.size();i++){
            if (students.get(i).getId()==id){
                Student student=students.get(i);
                return StudentResponse.builder()
                        .id(student.getId())
                        .name(student.getName())
                        .address(student.getAddress())
                        .phone(student.getPhone())
                        .build();

            }

        }
        return  null;

    }
}
