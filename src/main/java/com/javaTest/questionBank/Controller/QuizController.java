package com.javaTest.questionBank.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaTest.questionBank.Model.Question;
import com.javaTest.questionBank.Model.QuestionWapper;
import com.javaTest.questionBank.Service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	public QuizController() {
		System.out.println("Inside Quiz constructor");
	}
	@Autowired
	QuizService quizservice;
	
	@PostMapping("create")
	public ResponseEntity<String> getQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
		System.out.println("In create");
		return quizservice.createQuiz(category,numQ,title);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWapper>> getQuiz(@PathVariable Integer id){
		
		return quizservice.getQuiz(id);
	}
}
