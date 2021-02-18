package com.aiEnglish.teacherAvailableTime.services;

import com.aiEnglish.teacherAvailableTime.dtos.teacher.TeacherGetDto;
import com.aiEnglish.teacherAvailableTime.dtos.teacher.TeacherPostDto;
import com.aiEnglish.teacherAvailableTime.dtos.teacher.TeacherPutDto;
import com.aiEnglish.teacherAvailableTime.entities.Teacher;
import com.aiEnglish.teacherAvailableTime.mappers.TeacherMapper;
import com.aiEnglish.teacherAvailableTime.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public List<TeacherGetDto> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(teacherMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public TeacherGetDto create(TeacherPostDto teacherPostDto){
        Teacher teacher = teacherMapper.toEntity(teacherPostDto);
        return teacherMapper.fromEntity(teacherRepository.save(teacher));
    }

    public void delete(Long id) {teacherRepository.deleteById(id);}

    public TeacherGetDto findTeacherById(Long id) {
        Teacher teacher = teacherRepository.findByTeacherId(id);
        return teacherMapper.fromEntity(teacher);
    }

    public TeacherGetDto modify(Long id, TeacherPutDto teacherPutDto) {
        Teacher teacher = new Teacher();
        teacherMapper.copy(teacherPutDto, teacher);
        teacher.setId(id);

        return teacherMapper.fromEntity(teacherRepository.save(teacher));
    }

    public Boolean isExisted(Long id){
        Teacher teacher = teacherRepository.findByTeacherId(id);
        if(teacher == null)
            return false;
        return true;
    }

    public void clear() {
        teacherRepository.deleteAll();
    }
}
