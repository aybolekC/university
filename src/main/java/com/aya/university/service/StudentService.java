package com.aya.university.service;


import com.aya.university.entity.Address;
import com.aya.university.entity.Student;
import com.aya.university.repository.AddressRepository;
import com.aya.university.repository.StudentRepository;
import com.aya.university.request.CreateStudentRequest;
import com.aya.university.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;


    public StudentResponse createStudent(CreateStudentRequest createStudentRequest){

        Address address=new Address();
        address.setStreet(createStudentRequest.getStreet());
        address.setCity(createStudentRequest.getCity());

        address=addressRepository.save(address);

        Student student=new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());

        student.setAddress(address);
        student=studentRepository.save(student);



        return new StudentResponse(student);
    }


    public StudentResponse getById(Long id){
        return new StudentResponse(studentRepository.findById(id).get());

    }

}
