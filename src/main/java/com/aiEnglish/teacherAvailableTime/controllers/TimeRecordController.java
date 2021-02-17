package com.aiEnglish.teacherAvailableTime.controllers;

import com.aiEnglish.teacherAvailableTime.CsvReader;
import com.aiEnglish.teacherAvailableTime.Headers;
import com.aiEnglish.teacherAvailableTime.dtos.teacher.TeacherGetDto;
import com.aiEnglish.teacherAvailableTime.dtos.teacher.TeacherPostDto;
import com.aiEnglish.teacherAvailableTime.dtos.timeRecord.TimeRecordGetDto;
import com.aiEnglish.teacherAvailableTime.dtos.timeRecord.TimeRecordPostDto;
import com.aiEnglish.teacherAvailableTime.services.TeacherService;
import com.aiEnglish.teacherAvailableTime.services.TimeRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/timerecords")
public class TimeRecordController {
    private final TimeRecordService timeRecordService;
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TimeRecordGetDto>> find() {
        List<TimeRecordGetDto> list = timeRecordService.getAllTimeRecords();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/init")
    public ResponseEntity<Object> init() {
        String[] headers = new String[Headers.values().length];
        for(Headers header: Headers.values())
            headers[header.getIndex()] = header.getValue();

        List<String[]> data = CsvReader.readCSV("data/ExportedAvailableTimes.csv",headers);

        for(String[] row: data){
            Boolean isTeacherExisted = teacherService.isExisted(Long.valueOf(row[Headers.TEACHER_ID.getIndex()]));
            if(!isTeacherExisted){
                TeacherPostDto teacherPostDto = new TeacherPostDto();
                teacherPostDto.setId(Long.valueOf(row[Headers.TEACHER_ID.getIndex()]));
                teacherPostDto.setName(row[Headers.TEACHER_NAME.getIndex()]);
                teacherPostDto.setWeekly_expected_hours(
                        row[Headers.WEEKLY_EXPECTED_HOURS.getIndex()].isEmpty() ?
                                38.0:Double.valueOf(row[Headers.WEEKLY_EXPECTED_HOURS.getIndex()]));
                teacherPostDto.setWork_base(row[Headers.WORK_BASE.getIndex()]);
                teacherPostDto.setGmt_modified(row[Headers.GMT_MODIFIED.getIndex()]);
                teacherService.create(teacherPostDto);
            }

            TimeRecordPostDto timeRecordPostDto = new TimeRecordPostDto();
            timeRecordPostDto.setId(Long.valueOf(row[Headers.RECORD_ID.getIndex()]));
            timeRecordPostDto.setBatch_id(Long.valueOf(row[Headers.BATCH_ID.getIndex()]));
            timeRecordPostDto.setTeacher(Long.valueOf(row[Headers.TEACHER_ID.getIndex()]));
            timeRecordPostDto.setStartTime(row[Headers.START_TIME.getIndex()]);
            timeRecordPostDto.setEndTime(row[Headers.END_TIME.getIndex()]);
            timeRecordService.create(timeRecordPostDto);
        }
        return ResponseEntity.ok("");
    }
}
