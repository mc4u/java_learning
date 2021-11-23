package com.api.ApiTask.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.ApiTask.Sevice.CourseService;
import com.api.ApiTask.entity.Course;
import com.api.ApiTask.entity.Course;

@RestController
public class MainController {
	@Autowired
	public CourseService courseService;

	@GetMapping("/courses")
	public List<Course> getcourses() {
		return courseService.getcourses();

	}

	@GetMapping("/courses/{courseId}")
	public Course getcourse(@PathVariable long courseId) {
		return courseService.getcourse(courseId);

	}

	@PostMapping("/addcourse")
	public Course addcourse(@RequestBody Course course) {
		return courseService.addcourse(course);

	}

	@DeleteMapping("/courses/{courseId}")
		public ResponseEntity<HttpStatus> deletecourse(@PathVariable String courseId)	{
			try {
	 courseService.deleteid(Long.parseLong(courseId));
			
		return new ResponseEntity<>(HttpStatus.OK);
		
		}
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		
		
}

	}
}