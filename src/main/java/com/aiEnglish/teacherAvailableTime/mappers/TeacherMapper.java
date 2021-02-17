package com.aiEnglish.teacherAvailableTime.mappers;

import com.aiEnglish.teacherAvailableTime.dtos.teacher.TeacherGetDto;
import com.aiEnglish.teacherAvailableTime.dtos.teacher.TeacherPostDto;
import com.aiEnglish.teacherAvailableTime.dtos.teacher.TeacherPutDto;
import com.aiEnglish.teacherAvailableTime.entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TeacherMapper {
    Teacher toEntity(TeacherPostDto teacherPostDto);
    TeacherGetDto fromEntity(Teacher teacher);
    List<TeacherGetDto> fromEntities(List<Teacher> teachers);
    void copy(TeacherPutDto teacherPutDto, @MappingTarget Teacher teacher);
}
