package com.yash.quizapp.controller;

import com.yash.quizapp.Question;
import com.yash.quizapp.service.QuestionService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")

public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllquestions(){
        return questionService.getAllQuestions();
    }

    @PostMapping("/createQuestion")
    public Map<String, String> createQuestion(@RequestBody Question question) {
        // Assuming Question is a class representing your question entity
        // You can adjust the parameter and class names as per your actual implementation

        // Save the question to the database using the questionDao
        questionService.createQuestion(question);

        // Create a response object
        Map<String, String> response = new HashMap<>();
        response.put("status", "200");
        response.put("message", "Question created");

        // Return the response with status 200
        return response;
    }

    @PutMapping("updateQuestion/{questionId}")
    public Map<String, String> updateQuestion(@RequestBody Question question , @PathVariable("questionId") Integer questionId) {
        Map<String, String> response = new HashMap<>();
        try {
            questionService.updateQuestion(question, questionId);
            response.put("status", "200");
            response.put("message", "Question updated successfully");
            return response;
        } catch (Exception e) {
            response.put("error", "Failed to update question");
            return response;
        }
    }


    @DeleteMapping("deleteQuestion/{questionId}")
    public Map<String, String> deleteQuestion(@PathVariable Integer questionId) {
        Map<String, String> response = new HashMap<>();
        try {
            questionService.deleteQuestion(questionId);
            response.put("status", "200");
            response.put("message", "Question deleted successfully");
            return response;
        } catch (Exception e) {
            response.put("error", "Failed to delete question");
            return response;
        }
    }

    @GetMapping("getQuestion/{questionId}")
    public Question getQuestionById(@PathVariable Integer questionId) {

        return  questionService.getQuestionById(questionId);

    }

}
