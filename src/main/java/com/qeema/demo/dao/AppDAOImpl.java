package com.qeema.demo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qeema.demo.entity.Course;
import com.qeema.demo.entity.Review;
import com.qeema.demo.entity.Instructor;
import com.qeema.demo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {
    private final EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        this.entityManager.persist(course);
    }

    @Override
    @Transactional
    public void saveReview(Review review) {
        this.entityManager.persist(review);
    }

    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {
        this.entityManager.persist(instructor);
    }

    @Override
    @Transactional
    public void saveInstructorDetail(InstructorDetail instructorDetail) {
        this.entityManager.persist(instructorDetail);
    }

    @Override
    @Transactional
    public Course findCourseById(int id) {
        return this.entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public List<Course> findCoursesByInstructorId(int instructorId) {
        return this.entityManager
                .createQuery("SELECT c FROM Course c WHERE c.instructor.id = :instructorId", Course.class)
                .setParameter("instructorId", instructorId)
                .getResultList();
    }

    @Override
    @Transactional
    public Instructor findInstructorById(int id) {
        return this.entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public Instructor findInstructorByIdJoinFetch(int id) {
        return this.entityManager
                .createQuery("SELECT i FROM Instructor i LEFT JOIN FETCH i.courses WHERE i.id = :id", Instructor.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @Transactional
    public InstructorDetail findInstructorDetailById(int id) {
        return this.entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = findCourseById(id);
        if (course != null) {
            course.getInstructor().setCourses(null);
            this.entityManager.remove(course);
        }
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = findInstructorById(id);
        if (instructor != null) {
            instructor.getCourses().stream().forEach(course -> course.setInstructor(null));
            this.entityManager.remove(instructor);
        }
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = findInstructorDetailById(id);
        if (instructorDetail != null) {
            instructorDetail.getInstructor().setInstructorDetail(null);
            this.entityManager.remove(instructorDetail);
        }
    }

}
