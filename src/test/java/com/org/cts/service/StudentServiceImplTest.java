package com.org.cts.service;

import com.org.cts.model.Student;
import com.org.cts.repository.StudentRepo;
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
class StudentServiceImplTest {
@InjectMocks
private StudentServiceImpl studentServiceImpl;
@Mock
   private  StudentRepo studentRepo;
    @Test
    void createStudent() {
        Student student=new Student();
        student.setId(100);
        student.setName("naveen");
        student.setAddress("vza");
        studentServiceImpl.createStudent(student);
        Mockito.verify(studentRepo,Mockito.times(1)).save(student);

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
        Mockito.when(studentRepo.findAll()).thenReturn(list);
        List<Student> list1 = studentServiceImpl.getAll();
        Assertions.assertEquals(list.size(),list1.size());
    }
    @Test
    void updateStudent() {
        Student student=new Student();
        student.setId(100);
        student.setName("naveen");
        student.setAddress("vza");
        studentServiceImpl.updateStudent(student);
        Mockito.verify(studentRepo,Mockito.times(1)).save(student);
    }
    @Test
    void deleteById() {
            int id =100;
            String value = "naveen";
            String value2=studentServiceImpl.deleteById(100);
            Assertions.assertEquals(value,value2);
            Mockito.verify(studentRepo,Mockito.times(1)).deleteById(id);
        }


    @Test
    void getById() {
        int id =100;
        Student student= new Student();
        student.setId(100);
        student.setName("naveen");
        student.setAddress("hyd");
        Optional<Student> optional = Optional.of(student);
        Mockito.when(studentRepo.getById(id)).thenReturn(student);
        Optional<Student> optional1=studentServiceImpl.getById(id);
        Assertions.assertEquals(optional,optional1);
    }
}