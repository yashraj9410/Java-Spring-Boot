package com.yash.quizapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionQuery {

     public final String  customQuery = "SELECT * FROM question;";
}
