package com.aiEnglish.teacherAvailableTime.controllers;

import com.aiEnglish.teacherAvailableTime.ClassHeaders;
import com.aiEnglish.teacherAvailableTime.CsvReader;
import com.aiEnglish.teacherAvailableTime.dtos.englishClass.EnglishClassGetDto;
import com.aiEnglish.teacherAvailableTime.dtos.englishClass.EnglishClassPostDto;
import com.aiEnglish.teacherAvailableTime.services.EnglishClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/classes")
public class EnglishClassController {
    private final EnglishClassService englishClassService;

    @GetMapping
    public ResponseEntity<List<EnglishClassGetDto>> findAll() {
        return ResponseEntity.ok(englishClassService.getAllEnglishClasses());
    }

    @PostMapping
    public ResponseEntity<EnglishClassGetDto> create(@RequestBody EnglishClassPostDto englishClassPostDto) {
       return ResponseEntity.ok(englishClassService.create(englishClassPostDto));
    }

    @PostMapping("/init")
    public ResponseEntity initClass() {
        final int LENGTH = 106;
        String[] headers = new String[LENGTH];
        for(int i=0; i!=LENGTH; ++i)
            headers[i] = String.valueOf(i);

        List<String[]> data = CsvReader.readCSV("data/Timetable-Raw Data.csv",headers);
        final int TEACHER = 0;
        final int STUDIO = 1;
        final int DATETIME = 2;

        for(String[] row: data) {
            String[] class_id = row[ClassHeaders.CLASS_ID.getIndex()].split("_");
            if(class_id.length > DATETIME){
                EnglishClassPostDto englishClassPostDto = new EnglishClassPostDto();
                englishClassPostDto.setSpecial(row[ClassHeaders.SPECIAL.getIndex()]);
                englishClassPostDto.setUniform(row[ClassHeaders.UNIFORM.getIndex()]);
                englishClassPostDto.setStudio(class_id[STUDIO]);
                englishClassPostDto.setTopic(row[ClassHeaders.TOPIC.getIndex()]);

                final int DATE = 1;
                final int STARTTIME = 2;
                final int ENDTIME = 4;
                String[] dateTime = class_id[DATETIME].split(" ");
                String date = dateTime[DATE];
                String startTime = dateTime[STARTTIME];
                String endTime = dateTime[ENDTIME];

                englishClassPostDto.setDate(date);
                englishClassPostDto.setStartTime(startTime);
                englishClassPostDto.setEndTime(endTime);
                //englishClassPostDto.setTeacher(Long.valueOf("1204656639462871041"));
                englishClassService.create(englishClassPostDto);
            }
        }
        return ResponseEntity.ok().build();
    }
}
