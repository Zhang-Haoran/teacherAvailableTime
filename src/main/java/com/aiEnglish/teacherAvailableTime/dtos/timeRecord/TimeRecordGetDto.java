package com.aiEnglish.teacherAvailableTime.dtos.timeRecord;

import lombok.Data;

@Data
public class TimeRecordGetDto {
    private Long id;
    private String startTime;
    private String endTime;
    private Long teacher;
    private String teacher_name;
}
