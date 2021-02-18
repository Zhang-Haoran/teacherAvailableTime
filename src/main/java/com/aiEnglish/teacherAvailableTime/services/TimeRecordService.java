package com.aiEnglish.teacherAvailableTime.services;

import com.aiEnglish.teacherAvailableTime.dtos.timeRecord.TimeRecordGetDto;
import com.aiEnglish.teacherAvailableTime.dtos.timeRecord.TimeRecordPostDto;
import com.aiEnglish.teacherAvailableTime.dtos.timeRecord.TimeRecordPutDto;
import com.aiEnglish.teacherAvailableTime.entities.TimeRecord;
import com.aiEnglish.teacherAvailableTime.mappers.TimeRecordMapper;
import com.aiEnglish.teacherAvailableTime.repositories.TeacherRepository;
import com.aiEnglish.teacherAvailableTime.repositories.TimeRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimeRecordService {
    private final TimeRecordRepository timeRecordRepository;
    private final TimeRecordMapper timeRecordMapper;
    private final TeacherRepository teacherRepository;

    public List<TimeRecordGetDto> getAllTimeRecords(){
        return timeRecordRepository.findAll().stream()
                .map(timeRecordMapper::fromEntity)
                .collect(Collectors.toList());
    }

    public TimeRecordGetDto create(TimeRecordPostDto timeRecordPostDto){
        TimeRecord timeRecord = timeRecordRepository.save(timeRecordMapper.toEntity(timeRecordPostDto));
        TimeRecordGetDto timeRecordGetDto = timeRecordMapper.fromEntity(timeRecord);
        timeRecordGetDto.setTeacher_name(timeRecord.getTeacher().getName());

        return timeRecordGetDto;
    }

    public void delete(Long id) {timeRecordRepository.deleteById(id);}

    public List<TimeRecordGetDto> findTimeRecordsByTeacherId(Long id) {
        return timeRecordMapper.fromEntities(timeRecordRepository.findTimeRecordsByTeacherId(id));
    }

    public TimeRecordGetDto modify(Long id, TimeRecordPutDto timeRecordPutDto) {
        TimeRecord timeRecord = new TimeRecord();
        timeRecordMapper.copy(timeRecordPutDto, timeRecord);
        timeRecord.setId(id);

        return timeRecordMapper.fromEntity(timeRecordRepository.save(timeRecord));
    }

    public void clear() {
        timeRecordRepository.deleteAll();
    }
}
