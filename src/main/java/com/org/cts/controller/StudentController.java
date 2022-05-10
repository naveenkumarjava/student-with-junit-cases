package com.org.cts.controller;

import com.org.cts.model.Student;
import com.org.cts.repository.StudentRepo;
import com.org.cts.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
@Autowired
    StudentService studentService;

    @PostMapping("/create")
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }
@GetMapping("/getAll")
    public List<Student> getAll(){
       List<Student> sss = studentService.getAll();
        return sss;
    }
@PutMapping("/update")
public String updateStudent (@RequestBody Student student) {
   String ss =studentService.updateStudent(student);
   return ss;
}
@DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Integer id){
        String ww=studentService.deleteById(id);
        return ww;
}
@GetMapping("/getById/{id}")
    public Optional<Student> getById(@PathVariable Integer id){
        Optional<Student>optional=studentService.getById(id);
        return optional;


}
}




