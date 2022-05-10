package com.org.cts.controller;

import com.org.cts.model.Student;
import com.org.cts.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class StudentControllerTest {
    @InjectMocks
    private StudentController studentController;
    @Mock
   private StudentService studentService;

    @Test
    void createStudent() {
        Student student=new Student();
        student.setId(100);
        student.setName("naveen");
        student.setAddress("vza");
        studentController.createStudent(student);
        Mockito.verify(studentService,Mockito.times(1)).createStudent(student);
    }


    @Test
    void getAll() {
        List<Student> list =new ArrayList<>();
        Student student = new Student();
        student.setId(100);
        student.setName("raja");
        student.setAddress("vizag");
        list.add(student);
        Student student1 = new Student();
        student1.setId(100);
        student1.setName("raja");
        student1.setAddress("vizag");
        list.add(student1);
        Mockito.when(studentService.getAll()).thenReturn(list);
        List<Student> list1 = studentController.getAll();
        Assertions.assertEquals(list,list1);
    }

    @Test
    void updateStudent() {
        Student student=new Student();
        student.setId(100);
        student.setName("naveen");
        student.setAddress("vza");
        studentController.updateStudent(student);
        Mockito.verify(studentService,Mockito.times(1)).updateStudent(student);
    }

    @Test
    void deleteById() {
        int id =100;
        String value = null;
        String value2=studentService.deleteById(100);
        Assertions.assertEquals(value,value2);
    }

    @Test
    void getById() {
        int id =100;
        Student student= new Student();
        student.setId(100);
        student.setName("naveen");
        student.setAddress("hyd");
        Optional<Student> optional = Optional.of(student);
        Mockito.when(studentService.getById(id)).thenReturn(Optional.of(student));
        Optional<Student> optional1=studentController.getById(id);
        Assertions.assertEquals(optional,optional1);





    }
}