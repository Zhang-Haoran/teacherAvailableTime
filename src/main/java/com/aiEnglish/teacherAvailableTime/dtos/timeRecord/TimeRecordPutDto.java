package com.aiEnglish.teacherAvailableTime.dtos.timeRecord;

import lombok.Data;

@Data
public class TimeRecordPutDto {
    private String startTime;
    private String endTime;
    private Long teacher;
}
