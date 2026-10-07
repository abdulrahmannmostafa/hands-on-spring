package com.qeema.demo.dao;

import com.qeema.demo.entity.Course;
import com.qeema.demo.entity.Instructor;
import com.qeema.demo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void saveCourse(Course course);

    void saveInstructor(Instructor instructor);

    void saveInstructorDetail(InstructorDetail instructorDetail);

    Course findCourseById(int id);

    List<Course> findCoursesByInstructorId(int instructorId);

    Instructor findInstructorById(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteCourseById(int id);

    void deleteInstructorById(int id);

    void deleteInstructorDetailById(int id);
}