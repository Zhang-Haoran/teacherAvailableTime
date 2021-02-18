package com.aiEnglish.teacherAvailableTime.mappers;

import com.aiEnglish.teacherAvailableTime.dtos.englishClass.EnglishClassGetDto;
import com.aiEnglish.teacherAvailableTime.dtos.englishClass.EnglishClassPostDto;
import com.aiEnglish.teacherAvailableTime.dtos.englishClass.EnglishClassPutDto;
import com.aiEnglish.teacherAvailableTime.dtos.timeRecord.TimeRecordPutDto;
import com.aiEnglish.teacherAvailableTime.entities.EnglishClass;
import com.aiEnglish.teacherAvailableTime.entities.TimeRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface EnglishClassMapper {
    @Mapping(target = "teacher.id", source = "teacher")
    EnglishClass toEntity(EnglishClassPostDto englishClassPostDto);

    @Mapping(target = "teacher", source = "teacher.id")
    @Mapping(target = "teacher_name", source = "teacher.name")
    EnglishClassGetDto fromEntity(EnglishClass englishClass);

    @Mapping(target = "teacher", source = "teacher.id")
    @Mapping(target = "teacher_name", source = "teacher.name")
    List<EnglishClassGetDto> fromEntities(List<EnglishClass> englishClasses);

    @Mapping(target = "teacher.id", source = "teacher")
    void copy(EnglishClassPutDto englishClassPutDto, @MappingTarget EnglishClass englishClass);
}
