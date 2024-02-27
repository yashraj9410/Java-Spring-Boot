package com.yash.quizapp.controller;
import com.yash.quizapp.Question;
import com.yash.quizapp.service.QuestionService;
// import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController               // specify a rest controller for the spring boot
@RequestMapping("/question")

public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            List<Question> questions = questionService.getAllQuestions();

            if (questions.isEmpty()) {
                // If there are no questions found, return HTTP status code 204 (No Content)
                return ResponseEntity.noContent().build();
            }

            // If questions found, return them with HTTP status code 200 (OK)
            return ResponseEntity.ok(questions);

        } catch (Exception e) {
            // If an exception occurs, return HTTP status code 500 (Internal Server Error)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/createQuestion")
    public ResponseEntity<Map<String, String>> createQuestion(@RequestBody Question question) {
        try {
            // Save the question to the database using the questionService
            questionService.createQuestion(question);

            // Create a response object
            Map<String, String> response = new HashMap<>();
            response.put("status", "200");
            response.put("message", "Question created successfully");

            // Return the response with status 200
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // If an exception occurs, return an error response
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "500");
            errorResponse.put("error", "Internal Server Error");
            errorResponse.put("message", e.getMessage());

            // Return the error response with status 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("updateQuestion/{questionId}")
    public ResponseEntity<Map<String, String>> updateQuestion(@RequestBody Question question, @PathVariable("questionId") Integer questionId) {
        try {
            questionService.updateQuestion(question, questionId);

            // Create a response object for success
            Map<String, String> response = new HashMap<>();
            response.put("status", "200");
            response.put("message", "Question updated successfully");

            // Return the response with status 200
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // If an exception occurs, return an error response
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "500");
            errorResponse.put("error", "Failed to update question");
            errorResponse.put("message", e.getMessage());

            // Return the error response with status 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
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


    // controller for executing custom query
    @GetMapping("/custom")
    public List<Question> customQuery(){
        List<Question> questions  = questionService.executeCustomQuery();
        return questions;
    }

}
