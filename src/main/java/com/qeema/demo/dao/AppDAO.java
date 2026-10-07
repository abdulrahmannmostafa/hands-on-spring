package com.qeema.demo.dao;

import com.qeema.demo.entity.Course;
import com.qeema.demo.entity.Instructor;
import com.qeema.demo.entity.InstructorDetail;

public interface AppDAO {

    void saveCourse(Course course);

    void saveInstructor(Instructor instructor);

    void saveInstructorDetail(InstructorDetail instructorDetail);

    Course findCourseById(int id);

    Instructor findInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteCourseById(int id);

    void deleteInstructorById(int id);

    void deleteInstructorDetailById(int id);
}