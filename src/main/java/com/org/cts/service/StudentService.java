package com.org.cts.service;

import com.org.cts.model.Student;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public void createStudent(Student student);
    public List<Student> getAll();
    public String updateStudent (Student student);
    public String deleteById( Integer id);
    public Optional<Student> getById(Integer id);
}
