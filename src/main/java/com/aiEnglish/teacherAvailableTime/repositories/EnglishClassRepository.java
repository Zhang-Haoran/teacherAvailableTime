package com.aiEnglish.teacherAvailableTime.repositories;

import com.aiEnglish.teacherAvailableTime.entities.EnglishClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnglishClassRepository extends JpaRepository<EnglishClass, Long> {
    @Query("select e from EnglishClass e where e.teacher.id = :teacher_id")
    List<EnglishClass> findTimeRecordsByTeacherId(@Param("teacher_id") Long teacher_id);
}
