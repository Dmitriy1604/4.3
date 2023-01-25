package com.example.demo.repository;


import com.example.demo.model.Faculty;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    Collection<Faculty> findAllByColor(String color);
    Collection<Faculty> findAllByColorIgnoreCaseOrNameIgnoreCase(String color, String name);

    Collection<Student> findAllByFaculty_Id(long faculyId);

}
