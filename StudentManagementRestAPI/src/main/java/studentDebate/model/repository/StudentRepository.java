package com.lab.studentDebate.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.studentDebate.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
