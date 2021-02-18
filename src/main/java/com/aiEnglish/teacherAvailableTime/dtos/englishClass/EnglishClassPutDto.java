package com.aiEnglish.teacherAvailableTime.dtos.englishClass;

import lombok.Data;

@Data
public class EnglishClassPutDto {
    private String date;
    private String time;
    private String teacher;
}
