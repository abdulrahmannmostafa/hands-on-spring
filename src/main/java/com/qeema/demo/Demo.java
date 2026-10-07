package com.qeema.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.qeema.demo.dao.AppDAO;
import com.qeema.demo.entity.Instructor;
import com.qeema.demo.entity.InstructorDetail;
import com.qeema.demo.entity.Course;

import java.util.Arrays;

@SpringBootApplication
public class Demo {

	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// findInstructorDetail(appDAO);
			deleteInstructor(appDAO);
			// deleteInstructorDetail(appDAO);

		};
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		System.out.println("Creating new instructor object...");

		Instructor instructor = new Instructor("Abdelrahman", "Mostafa", "abdelrahman.mostafa@example.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/abdomostafa", "Coding");

		Course course1 = new Course("Java Programming");
		Course course2 = new Course("Spring Framework");

		course1.setInstructor(instructor);
		course2.setInstructor(instructor);

		instructorDetail.setInstructor(instructor);

		instructor.setInstructorDetail(instructorDetail);
		instructor.addCourse(course2);
		instructor.addCourse(course1);

		appDAO.saveInstructor(instructor);

		System.out.println("Done saving the instructor!");
	}

	private void findInstructor(AppDAO appDAO) {
		int instructorId = 3;
		System.out.println("Finding instructor with id: " + instructorId);
		Instructor instructor = appDAO.findInstructorById(instructorId);
		System.out.println("Found instructor: " + instructor);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int instructorDetailId = 3;
		System.out.println("Finding instructor detail with id: " + instructorDetailId);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(instructorDetailId);
		System.out.println("Found instructor detail: " + instructorDetail);
	}

	private void deleteInstructor(AppDAO appDAO) {
		int instructorId = 3;
		System.out.println("Deleting instructor with id: " + instructorId);
		appDAO.deleteInstructorById(instructorId);
		System.out.println("Done deleting the instructor!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int instructorDetailId = 3;
		System.out.println("Deleting instructor detail with id: " + instructorDetailId);
		appDAO.deleteInstructorDetailById(instructorDetailId);
		System.out.println("Done deleting the instructor detail!");
	}
}