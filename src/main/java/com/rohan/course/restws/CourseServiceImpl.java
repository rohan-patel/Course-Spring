package com.rohan.course.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.rohan.course.restws.data.Course;

@Service
public class CourseServiceImpl implements CourseService {

	Map<Long, Course> courses = new HashMap<>();
	long currId = 123;

	public CourseServiceImpl() {
		init();
	}

	private void init() {
		Course course = new Course();
		course.setId(currId);
		course.setName("Learn Java");
		course.setPrice(1000);
		course.setTaughtBy("Bharath Thippireddy");
		course.setRating(4.2);

		courses.put(course.getId(), course);
	}

	@Override
	public List<Course> getCourses() {
		Collection<Course> results = courses.values();
		List<Course> response = new ArrayList<>(results);
		return response;
	}

	@Override
	public Course getCourse(long id) {
		return courses.get(id);
	}

	@Override
	public Response createCourse(Course course) {
		course.setId(++currId);
		courses.put(course.getId(), course);
		return Response.ok(course).build();
	}

	@Override
	public Response updateCourse(Course course) {
		Course currCourse = courses.get(course.getId());
		Response response;
		if (currCourse != null) {
			courses.put(course.getId(), course);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deleteCourse(long id) {
		Course currCourse = courses.get(id);
		Response response;
		if (currCourse != null) {
			courses.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

}
