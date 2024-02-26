package com.yash.quizapp.service;

import com.yash.quizapp.Question;
import com.yash.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

// service and component does the same work
@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions(){
        return questionDao.findAll();
    }

    public void createQuestion(Question question){
        questionDao.save(question);
    }

    public void deleteQuestion(Integer id){
        questionDao.deleteById(id);
    }

    public void updateQuestion(Question question, Integer Id){
        Question extQuestion = questionDao.findQuestionById(Id);
        extQuestion.setQuestion_title(question.getQuestion_title());
        extQuestion.setOptions(question.getOptions());
        extQuestion.setAnswer(question.getAnswer());

        questionDao.save(extQuestion);

    }

    public Question getQuestionById(Integer Id){
        return questionDao.findQuestionById(Id);
    }
}
