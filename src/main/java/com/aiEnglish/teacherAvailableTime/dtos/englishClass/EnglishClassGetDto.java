package com.aiEnglish.teacherAvailableTime.dtos.englishClass;

import lombok.Data;

@Data
public class EnglishClassGetDto {
    private Long id;
    private String date;
    private String time;
    private Long teacher;
    private String teacher_name;
}
