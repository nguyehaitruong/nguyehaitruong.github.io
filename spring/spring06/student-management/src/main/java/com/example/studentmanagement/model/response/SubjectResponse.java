package com.example.studentmanagement.model.response;

import com.example.studentmanagement.statics.SubjectType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectResponse {
    private  int id;
    private  String name;
    private  int credit;
    private SubjectType subjectType;

}
