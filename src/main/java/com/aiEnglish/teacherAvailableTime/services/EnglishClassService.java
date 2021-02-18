package com.aiEnglish.teacherAvailableTime.services;

import com.aiEnglish.teacherAvailableTime.dtos.englishClass.EnglishClassGetDto;
import com.aiEnglish.teacherAvailableTime.dtos.englishClass.EnglishClassPostDto;
import com.aiEnglish.teacherAvailableTime.entities.EnglishClass;
import com.aiEnglish.teacherAvailableTime.mappers.EnglishClassMapper;
import com.aiEnglish.teacherAvailableTime.repositories.EnglishClassRepository;
import com.aiEnglish.teacherAvailableTime.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnglishClassService {
    private final EnglishClassRepository englishClassRepository;
    private final EnglishClassMapper englishClassMapper;
    private final TeacherRepository teacherRepository;

    public List<EnglishClassGetDto> getAllEnglishClasses() {
        return englishClassRepository.findAll().stream()
                .map(englishClassMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public EnglishClassGetDto create(EnglishClassPostDto englishClassPostDto) {
        EnglishClass englishClass = englishClassRepository.save(englishClassMapper.toEntity(englishClassPostDto));
        EnglishClassGetDto englishClassGetDto = englishClassMapper.fromEntity(englishClass);
        englishClassGetDto.setTeacher_name(englishClass.getTeacher().getName());

        return englishClassGetDto;
    }
}
