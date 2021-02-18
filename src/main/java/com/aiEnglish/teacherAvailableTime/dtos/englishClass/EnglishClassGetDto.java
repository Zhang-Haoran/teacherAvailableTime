package com.aiEnglish.teacherAvailableTime.dtos.englishClass;

import lombok.Data;

@Data
public class EnglishClassGetDto {
    private Long id;
    private String date;
    private String startTime;
    private String endTime;
    private String special;
    private String uniform;
    private String studio;
    private String topic;
    private Long teacher;
}
