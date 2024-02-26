package com.yash.quizapp.dao;

import com.yash.quizapp.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                         // table class name , type of primary key
public interface QuestionDao extends JpaRepository<Question,Integer> {

    // this is going to be handled by the data -jpa package
    // all the CRUD will be handled by JPA repository

    Question findQuestionById(Integer Id);



}
