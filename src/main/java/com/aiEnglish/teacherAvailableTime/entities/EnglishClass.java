package com.aiEnglish.teacherAvailableTime.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="classes")
public class EnglishClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="class_id")
    private Long id;

    @Column(name="date")
    private String date;

    @Column(name="startTime")
    private String startTime;

    @Column(name="endTime")
    private String endTime;

    @Column(name="special")
    private String special;

    @Column(name="uniform")
    private String uniform;

    @Column(name="studio")
    private String studio;

    @Column(name="topic")
    private String topic;

    @Column(name="teacher")
    private Long teacher;
}
