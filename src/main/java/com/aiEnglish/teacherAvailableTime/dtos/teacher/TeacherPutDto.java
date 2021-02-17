package com.aiEnglish.teacherAvailableTime.dtos.teacher;

import lombok.Data;

@Data
public class TeacherPutDto {
    private String name;
    private Double weekly_expected_hours;
    private String work_base;
    private String gmt_modified;
}
