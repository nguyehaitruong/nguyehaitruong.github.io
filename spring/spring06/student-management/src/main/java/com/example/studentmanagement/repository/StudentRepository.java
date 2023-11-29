package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.model.request.StudentUpdateRequest;
import com.example.studentmanagement.util.FileUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Builder
@AllArgsConstructor

public class StudentRepository {
    private static final String STUDENT_DATA_FILE_NAME = "data/students.json";
    private final FileUtil<Student> fileUtil;
    public static int AUTO_ID = 1000;

    public List<Student> getStudents(){
       return fileUtil.readDataFromFile(STUDENT_DATA_FILE_NAME, Student[].class);
    }
//    public List<Student> delete(int id)  {
//        List<Student> students = getStudents();
//
//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).getId() == id) {
//                students.remove(i);
//                fileUtil.writeDataToFile(STUDENT_DATA_FILE_NAME, students);
//                return students;
//            }
//        }
//        return null;
//    }
    public List<Student> createStudent(Student student) {
        List<Student> students = getStudents();
        if (CollectionUtils.isEmpty(students)) {
            students = new ArrayList<>();
        }
        students.add(student);
        fileUtil.writeDataToFile(STUDENT_DATA_FILE_NAME, students);
        return students;
    }
    public Student findById(int id)  {
        List<Student> students = getStudents();

        return students.stream().filter(b -> b.getId() == id).findFirst().get();
    }
//    public List<Student> updateStudent(StudentUpdateRequest student) {
//        List<Student> students = getStudents();
//
//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).getId() == student.getId()) {
//                students.get(i).setName(student.getName());
//                students.get(i).setAddress(student.getAddress());
//                students.get(i).setPhone(student.getPhone());
//
//                fileUtil.writeDataToFile(STUDENT_DATA_FILE_NAME, students);
//                return students;
//            }
//        }
//        return null;
//    }
//    public void save(Student student) {
//        List<Student> students = getStudents();
//        students.add(student);
//        fileUtil.writeDataToFile(STUDENT_DATA_FILE_NAME, students);
//    }
    public void save(List<Student> students) {
        fileUtil.writeDataToFile(STUDENT_DATA_FILE_NAME, students);
    }



}
