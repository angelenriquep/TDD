package com.example.external.course;

import com.example.internal.courses.application.CourseCreator;
import com.example.internal.courses.application.CourseRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class CoursePutController {

    private CourseCreator creator;

    public CoursePutController(CourseCreator creator) {
        this.creator = creator;
    }

    @PutMapping(path = "/courses/{id}")
    public ResponseEntity<String> create(@PathVariable String id, @RequestBody Request request)  {
        //TDD
        creator.create(new CourseRequest(id, request.Name(), request.Duration()));

        return new ResponseEntity(HttpStatus.CREATED);
    }
}


// DTO, Mutable, Constructor not working with Spring
final class Request {
    private String name;
    private String duration;

    String Name() {
        return name;
    }

    String Duration() {
        return duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
