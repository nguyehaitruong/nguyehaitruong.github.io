package com.example.petshop.statics;

public enum Status {
    CHUAPHEDUEY("chưa phê duyêt"),
    DAPHEDUYET("đã phê duyệt"),
    TUCHOI("từ chối");

    private final String moTa;


    Status(String moTa) {
        this.moTa = moTa;
    }
}
