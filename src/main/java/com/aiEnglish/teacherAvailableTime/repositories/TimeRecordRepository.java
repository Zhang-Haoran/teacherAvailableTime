package com.aiEnglish.teacherAvailableTime.repositories;

import com.aiEnglish.teacherAvailableTime.entities.TimeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TimeRecordRepository extends JpaRepository<TimeRecord, Long> {
    @Query("select t from TimeRecord t where t.teacher.id = :teacher_id")
    List<TimeRecord> findTimeRecordsByTeacherId(@Param("teacher_id") Long teacher_id);

    @Query("select t from TimeRecord t where t.date = :date")
    List<TimeRecord> findTimeRecordsByDate(@Param("date") String date);
}
