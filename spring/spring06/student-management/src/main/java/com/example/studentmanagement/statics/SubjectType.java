package com.example.studentmanagement.statics;

public enum SubjectType {
    CO_SO("Môn Cơ Sở"),
    NGANH("Môn Chuyên Ngành"),
    DAI_CUONG("Môn Đại Cương");

    private final String moTa;


    SubjectType(String moTa) {
        this.moTa = moTa;
    }
}
