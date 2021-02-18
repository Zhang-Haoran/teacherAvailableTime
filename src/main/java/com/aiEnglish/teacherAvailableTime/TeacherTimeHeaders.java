package com.aiEnglish.teacherAvailableTime;

public enum TeacherTimeHeaders {
    TEACHER_ID(0,"foreign_teacher_id"),
    BATCH_ID(1,"batch_id"),
    TEACHER_NAME(2,"foreign_teacher_name"),
    WEEKLY_EXPECTED_HOURS(3,"weekly_expected_hours"),
    RECORD_ID(4,"record_id"),
    START_TIME(5,"start_time"),
    END_TIME(6,"end_time"),
    WORK_BASE(7,"work_base"),
    GMT_MODIFIED(8, "gmt_modified");

    private String value;
    private int index;
    TeacherTimeHeaders(int index, String value){
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
