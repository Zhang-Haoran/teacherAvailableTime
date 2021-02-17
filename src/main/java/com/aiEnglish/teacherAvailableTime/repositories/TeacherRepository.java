package com.aiEnglish.teacherAvailableTime.repositories;

import com.aiEnglish.teacherAvailableTime.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("select t from Teacher t where t.id = :teacher")
    Teacher findByTeacherId(@Param("teacher") Long teacher);
}
