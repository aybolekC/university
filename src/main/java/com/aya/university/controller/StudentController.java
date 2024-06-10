package com.aya.university.controller;


import com.aya.university.request.CreateStudentRequest;
import com.aya.university.response.StudentResponse;
import com.aya.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest){

        return studentService.createStudent(createStudentRequest);
    }



    @GetMapping("/getById/{id}")
    public StudentResponse getById(@PathVariable Long id){

        return studentService.getById(id);
    }


}
