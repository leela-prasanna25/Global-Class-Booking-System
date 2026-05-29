package com.bookings.classbooking.entity;

import jakarta.persistence.*;

@Entity
public class Offering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batchName;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Offering() {
    }

    public Long getId() {
        return id;
    }

    public String getBatchName() {
        return batchName;
    }

    public Course getCourse() {
        return course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}