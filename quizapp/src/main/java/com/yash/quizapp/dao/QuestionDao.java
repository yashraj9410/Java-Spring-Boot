package com.yash.quizapp.dao;

import com.yash.quizapp.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository                                         // table class name , type of primary key
public interface QuestionDao extends JpaRepository<Question,Integer> {

    // this is going to be handled by the data -jpa package
    // all the CRUD (in the database ) will be handled by JPA repository

    Question findQuestionById(Integer Id);    // handles internally by the JPA repository


    // executing a raw query
    @Query(value = "SELECT * FROM question;", nativeQuery = true)
    List<Question> findByCustomQuery(); // Modify the return type accordingly



}
