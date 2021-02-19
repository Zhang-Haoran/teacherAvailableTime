package com.aiEnglish.teacherAvailableTime.services;

import com.aiEnglish.teacherAvailableTime.dtos.englishClass.EnglishClassGetDto;
import com.aiEnglish.teacherAvailableTime.dtos.englishClass.EnglishClassPostDto;
import com.aiEnglish.teacherAvailableTime.dtos.englishClass.EnglishClassPutDto;
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

    public List<EnglishClassGetDto> getAllEnglishClasses() {
        return englishClassRepository.findAll().stream()
                .map(englishClassMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public EnglishClassGetDto create(EnglishClassPostDto englishClassPostDto) {
        EnglishClass englishClass = englishClassMapper.toEntity(englishClassPostDto);
        EnglishClass savedEnglishClass = englishClassRepository.save(englishClass);
        EnglishClassGetDto englishClassGetDto = englishClassMapper.fromEntity(savedEnglishClass);

        return englishClassGetDto;
    }

    public EnglishClassGetDto modify(Long id, EnglishClassPutDto englishClassPutDto) {
        EnglishClass englishClass = new EnglishClass();
        englishClassMapper.copy(englishClassPutDto, englishClass);
        englishClass.setId(id);

        return englishClassMapper.fromEntity(englishClassRepository.save(englishClass));
    }

    public void delete(Long id) {
        englishClassRepository.deleteById(id);
    }

    public List<EnglishClassGetDto> findEnglishClassesByDate(String date) {
        List<EnglishClass> englishClasses = englishClassRepository.findEnglishClassByDate(date);
        return englishClassMapper.fromEntities(englishClasses);
    }
}
