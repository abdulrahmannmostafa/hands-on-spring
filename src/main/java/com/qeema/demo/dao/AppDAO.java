package com.qeema.demo.dao;

import com.qeema.demo.entity.Instructor;
import com.qeema.demo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorById(int id);

    void deleteInstructorDetailById(int id);
}