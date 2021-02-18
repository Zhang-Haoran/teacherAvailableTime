package com.aiEnglish.teacherAvailableTime;

public enum ClassHeaders {
    CLASS_ID(0, "Class ID"),
    SPECIAL(2, "Special"),
    TOPIC(7, "Topic"),
    UNIFORM(11, "Uniform");
    private String value;
    private int index;
    ClassHeaders(int index, String value){
        this.index = index;
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public int getIndex(){
        return index;
    }
}
