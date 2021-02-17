package com.aiEnglish.teacherAvailableTime.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="records")
public class TimeRecord {
    @Id
    @Column(name="record_id")
    private Long id;

    @Column(name="currency")
    private String startTime;

    @Column(name="date")
    private String endTime;

    @Column(name="batch_id")
    private Long batch_id;

    @ManyToOne
    @JoinColumn(name = "foreign_teacher_id", nullable = false)
    private Teacher teacher;
}
