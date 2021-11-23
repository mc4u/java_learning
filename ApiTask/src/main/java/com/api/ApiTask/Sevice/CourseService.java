package com.api.ApiTask.Sevice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.ApiTask.entity.Course;


@Component
public interface  CourseService {
	public List<Course> getcourses();
	public Course getcourse(long courseId  );
	public Course addcourse( Course course);
	
	public String deleteid(long parseLong);
	


}
