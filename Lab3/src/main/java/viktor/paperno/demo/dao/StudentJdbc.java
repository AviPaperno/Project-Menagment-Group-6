package viktor.paperno.demo.dao;

import viktor.paperno.demo.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentJdbc {

    private final JdbcTemplate jdbcTemplate;

    public StudentJdbc(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student get(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM STUDENT WHERE id = ?",this::mapStudent, id);
    }

    public void set(Student student)
    {
        jdbcTemplate.update(
                "INSERT INTO STUDENT(name, surname, second_name, study_group_id) VALUES (?,?,?,?)",
                student.getName(),student.getSurname(),student.getSecondName(),student.getStudyGroupId()
        );

    }

    private Student mapStudent(ResultSet rs,int i) throws SQLException
    {

        Student student = new Student(
                rs.getInt("id"),
                rs.getString("surname"),
                rs.getString("name"),
                rs.getString("second_name"),
                rs.getInt("study_group_id")
        );

        return student;
    }


    public List<Student> get_all()
    {
        return jdbcTemplate.queryForObject("SELECT * FROM STUDENT",this::mapStudents);
    }

    public List<Student> get_by_group_id(int group_id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM STUDENT WHERE STUDY_GROUP_ID= ?",this::mapStudents,group_id);
    }

    public void remove_student_by_id(int id)
    {
        Object[] args = new Object[] {id};
        jdbcTemplate.update("DELETE FROM STUDENT WHERE ID= ?",args);
    }

    public void changeGroup(int id, int new_group_id)
    {
        Object[] args = new Object[] {new_group_id,id};
        jdbcTemplate.update("UPDATE STUDENT SET STUDY_GROUP_ID = ? WHERE ID= ?",args);
    }

    private List<Student> mapStudents(ResultSet rs,int i) throws SQLException
    {
        List students = new ArrayList<Student>();

        do {
            Student student = new Student(
                    rs.getInt("id"),
                    rs.getString("surname"),
                    rs.getString("name"),
                    rs.getString("second_name"),
                    rs.getInt("study_group_id")
            );
            students.add(student);


        } while (rs.next());

        return students;
    }


}
