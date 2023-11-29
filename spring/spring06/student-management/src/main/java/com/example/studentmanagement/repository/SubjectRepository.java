package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.entity.Subject;
import com.example.studentmanagement.model.request.StudentUpdateRequest;
import com.example.studentmanagement.util.FileUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;



@Repository
@Builder
@AllArgsConstructor

public class SubjectRepository {
    private static final String SUBJECT_DATA_FILE_NAME = "data/subject.json";
    private final FileUtil<Subject> fileUtil;
    public static int AUTO_ID = 1000;

    public List<Subject> getSubject(){
       return fileUtil.readDataFromFile(SUBJECT_DATA_FILE_NAME, Subject[].class);
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
    public List<Subject> createSubject(Subject subject) {
        List<Subject> subjects = getSubject();
        if (CollectionUtils.isEmpty(subjects)) {
            subjects = new ArrayList<>();
        }
        subjects.add(subject);
        fileUtil.writeDataToFile(SUBJECT_DATA_FILE_NAME, subjects);
        return subjects;
    }
    public Subject findById(int id)  {
        List<Subject> subjects = getSubject();

        return subjects.stream().filter(b -> b.getId() == id).findFirst().get();
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

    public void save(List<Subject> subjects) {
        fileUtil.writeDataToFile(SUBJECT_DATA_FILE_NAME, subjects);
    }



}
