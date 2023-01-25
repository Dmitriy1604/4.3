package com.example.demo.service;



import com.example.demo.exception.FacultyNotFoundException;
import com.example.demo.model.Faculty;
import com.example.demo.model.Student;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public  class FacultyService {

        private final FacultyRepository facultyRepository;
        private final StudentRepository studentRepository;


        public FacultyService(FacultyRepository facultyRepository,
                              StudentRepository studentRepository){
            this.facultyRepository = facultyRepository;
            this.studentRepository = studentRepository;

        }
        public Faculty create(Faculty faculty){
            faculty.setId(null);
            return facultyRepository.save(faculty);
        }
        public Faculty read(long id){
            return facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException (id));
}
        public Faculty update(long id,
                      Faculty faculty) {
        Faculty oldFaculty = read (id);
        oldFaculty.setName(faculty.getName());
        oldFaculty.setName(faculty.getColor());
        return facultyRepository.save(oldFaculty);
}
        public Faculty delete(long id){
            Faculty faculty = read(id);
            facultyRepository.delete(faculty);
            return faculty;
}
        public Collection<Faculty> findByColor(String color) {
            return facultyRepository.findAllByColor ( color );

        }
    public Collection<Faculty> findByColorOrName(String colorOrName){
        return facultyRepository.findAllByColorIgnoreCaseOrNameIgnoreCase(colorOrName, colorOrName);

    }
    public Collection<Student> getStudentsByFaculty(long id) {
        Faculty faculty = read(id);
        return faculty.getStudents();


    }
}
