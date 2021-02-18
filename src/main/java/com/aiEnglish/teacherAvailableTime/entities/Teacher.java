package com.aiEnglish.teacherAvailableTime.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="teachers")

public class Teacher {
    @Id
    @Column(name="teacher_id")
    private Long id;

    @Column(name="teacher_name")
    private String name;

    @Column(name="weekly_expected_hours")
    private Double weekly_expected_hours;

    @Column(name="work_base")
    private String work_base;

    @OneToMany(mappedBy = "teacher")
    private Set<TimeRecord> timeRecords;

    @OneToMany(mappedBy = "teacher")
    private Set<EnglishClass> englishClasses;
}
