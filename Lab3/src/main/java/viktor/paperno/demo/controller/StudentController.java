package viktor.paperno.demo.controller;


import org.springframework.web.bind.annotation.RequestParam;
import viktor.paperno.demo.dao.StudentJdbc;

import viktor.paperno.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.util.List;


@RestController
public class StudentController  {

    private final StudentJdbc studentJdbc;

    public StudentController(StudentJdbc studentJdbc)
    {
        this.studentJdbc = studentJdbc;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id)
    {

        Student student = studentJdbc.get(id);
        System.out.println(student);
        return student;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents()
    {
        List<Student> students = studentJdbc.get_all();

        return students;
    }

    @GetMapping("/students/{group}")
    public List<Student> getStudentsByGroupId(@PathVariable int group)
    {
        List<Student> students = studentJdbc.get_by_group_id(group);

        return students;
    }

    @GetMapping("/student/drop/{id}")
    public void dropStudent(@PathVariable int id)
    {
        studentJdbc.remove_student_by_id(id);
    }

    @GetMapping("student/{id}/{new_group_id}")
    public Student updateStudent(@PathVariable int id, @PathVariable int new_group_id)
    {
        studentJdbc.changeGroup(id,new_group_id);
        return getStudent(id);
    }

    @GetMapping(value = "/student", params = {"name","surname","second_name","study_group_id"})
    public void setStudents(@RequestParam String name,@RequestParam String surname,@RequestParam String second_name,@RequestParam int study_group_id)
    {
        Student student = new Student(
                0,
                surname,
                name,
                second_name,
                study_group_id
        );

        studentJdbc.set(student);
    }




}
