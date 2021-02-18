package com.aiEnglish.teacherAvailableTime.controllers;

import com.aiEnglish.teacherAvailableTime.dtos.teacher.TeacherGetDto;
import com.aiEnglish.teacherAvailableTime.dtos.teacher.TeacherPostDto;
import com.aiEnglish.teacherAvailableTime.dtos.teacher.TeacherPutDto;
import com.aiEnglish.teacherAvailableTime.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherGetDto>> find() {
        List<TeacherGetDto> list = teacherService.getAllTeachers();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody TeacherPostDto teacherPostDto) {
        TeacherGetDto teacherGetDto = teacherService.create(teacherPostDto);
        return ResponseEntity.ok(teacherGetDto);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<TeacherGetDto> update(@PathVariable Long teacherId, @RequestBody TeacherPutDto teacherPutDto) {
        return ResponseEntity.ok(teacherService.modify(teacherId, teacherPutDto));
    }

    @DeleteMapping("/teacherId")
    public ResponseEntity delete(@PathVariable Long teacherId) {
        teacherService.delete(teacherId);
        return ResponseEntity.ok().build();
    }
}
