package com.aiEnglish.teacherAvailableTime.controllers;

import com.aiEnglish.teacherAvailableTime.CsvReader;
import com.aiEnglish.teacherAvailableTime.TeacherTimeHeaders;
import com.aiEnglish.teacherAvailableTime.dtos.teacher.TeacherPostDto;
import com.aiEnglish.teacherAvailableTime.dtos.timeRecord.TimeRecordGetDto;
import com.aiEnglish.teacherAvailableTime.dtos.timeRecord.TimeRecordPostDto;
import com.aiEnglish.teacherAvailableTime.dtos.timeRecord.TimeRecordPutDto;
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
    public ResponseEntity<List<TimeRecordGetDto>> findAll() {
        List<TimeRecordGetDto> list = timeRecordService.getAllTimeRecords();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/init")
    public ResponseEntity<Object> init() {
        timeRecordService.clear();
        teacherService.clear();
        String[] headers = new String[TeacherTimeHeaders.values().length];
        for(TeacherTimeHeaders header: TeacherTimeHeaders.values())
            headers[header.getIndex()] = header.getValue();

        List<String[]> data = CsvReader.readCSV("data/ExportedAvailableTimes.csv",headers);

        for(String[] row: data){
            Boolean isTeacherExisted = teacherService.isExisted(Long.valueOf(row[TeacherTimeHeaders.TEACHER_ID.getIndex()]));
            if(!isTeacherExisted){
                TeacherPostDto teacherPostDto = new TeacherPostDto();
                teacherPostDto.setId(Long.valueOf(row[TeacherTimeHeaders.TEACHER_ID.getIndex()]));
                teacherPostDto.setName(row[TeacherTimeHeaders.TEACHER_NAME.getIndex()]);
                teacherPostDto.setWeekly_expected_hours(
                        row[TeacherTimeHeaders.WEEKLY_EXPECTED_HOURS.getIndex()].isEmpty() ?
                                38.0:Double.valueOf(row[TeacherTimeHeaders.WEEKLY_EXPECTED_HOURS.getIndex()]));
                teacherPostDto.setWork_base(row[TeacherTimeHeaders.WORK_BASE.getIndex()]);

                teacherService.create(teacherPostDto);
            }

            TimeRecordPostDto timeRecordPostDto = new TimeRecordPostDto();
            timeRecordPostDto.setTeacher(Long.valueOf(row[TeacherTimeHeaders.TEACHER_ID.getIndex()]));
            timeRecordPostDto.setStartTime(row[TeacherTimeHeaders.START_TIME.getIndex()]);
            timeRecordPostDto.setEndTime(row[TeacherTimeHeaders.END_TIME.getIndex()]);
            timeRecordService.create(timeRecordPostDto);
        }
        return ResponseEntity.ok("");
    }

    @PutMapping("/{timeRecordId}")
    public ResponseEntity<TimeRecordGetDto> update(@PathVariable Long timeRecordId, @RequestBody TimeRecordPutDto timeRecordPutDto) {
        return ResponseEntity.ok(timeRecordService.modify(timeRecordId, timeRecordPutDto));
    }

    @DeleteMapping("/{timeRecordId}")
    public ResponseEntity delete(@PathVariable Long timeRecordId) {
        timeRecordService.delete(timeRecordId);
        return ResponseEntity.ok().build();
    }
}
