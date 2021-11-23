package com.api.ApiTask.Sevice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.ApiTask.Repository.Repository;
//import com.api.ApiTask.Repository.Repository;
import com.api.ApiTask.entity.Course;

@Service
public class CourseServiceImp implements CourseService {

	
	List<Course> list;

	public CourseServiceImp() {
		list = new ArrayList<>();
		list.add(new Course(1, "Physics", "basics"));
		list.add(new Course(2, "Biology", "difficult"));
	}

	@Override
	public List<Course> getcourses() {

		return list;

	}

	@Override
	public Course getcourse(long courseId) {
		Course c = null;

		for (Course course : list) {
			if (course.getId() == courseId) {
				c = course;
				break;
			}

		}
		return c;

	}

	@Override
	public Course addcourse(Course course) {
		list.add(course);
		return course;
	}

	public String deleteid(long courseId) {

		for (Course course : list) {
			if (course.getId() == courseId) {
				list.remove(course);
				
				

			}
		}
		return "suucessfull";

		

		
	}
}
