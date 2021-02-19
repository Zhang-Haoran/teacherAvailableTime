package com.aiEnglish.teacherAvailableTime.dtos.timeRecord;

import lombok.Data;

@Data
public class TimeRecordPostDto {
    private String startTime;
    private String endTime;
    private String date;
    private Long teacher;
}
