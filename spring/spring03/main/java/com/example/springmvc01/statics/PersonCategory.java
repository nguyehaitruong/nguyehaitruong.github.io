package com.example.springmvc01.statics;

public enum PersonCategory {

    adult("người lớn"),

    KID("Thiếu nhi");

    public String value;

    PersonCategory(String value) {
        this.value = value;
    }

}
