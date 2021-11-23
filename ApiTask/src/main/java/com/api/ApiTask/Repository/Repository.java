package com.api.ApiTask.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.api.ApiTask.entity.Course;
@Component
public interface  Repository  extends JpaRepository<Course,Long>{

//	Course c = new Course();
//	Course c1 = new Course(2,"C1");
//	Course c2 = new Course(3,"C1" , "d1");	
//	
}
