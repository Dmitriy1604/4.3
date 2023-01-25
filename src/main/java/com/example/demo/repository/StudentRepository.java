package com.example.demo.repository;

import com.example.demo.entity.AverageAgeOfStudents;
import com.example.demo.entity.NumberOfStudents;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findAllByAge(int age);

    Collection<Student> findAllByAgeBetween(int minAge, int maxAge);
    @Query(value = "select count(*) as numberOfStudents from student", nativeQuery = true)
    NumberOfStudents getAllStudentsNumber();

    @Query(value = "select round(avg(age)) as averageAgeOfStudents from student", nativeQuery = true)
    AverageAgeOfStudents getAverageAge();

    @Query(value = "select * from student order by id DESC LIMIT :count", nativeQuery = true)
    List<Student> getLastStudentsById(@Param("count") int count);


}