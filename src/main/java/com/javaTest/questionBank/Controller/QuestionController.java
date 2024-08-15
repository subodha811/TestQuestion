package com.javaTest.questionBank.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaTest.questionBank.Model.Question;
import com.javaTest.questionBank.Service.QuestionService;

@RestController
@RequestMapping("/test")
public class QuestionController {
	
	@Autowired
	QuestionService qs;
	
	
	@GetMapping("/questions")
	public ResponseEntity<List<Question>> questions() {
		
		return qs.getAllQuestion();
	}
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> questionsByCategory(@PathVariable("category") String category){
		return qs.getQuestionByCategory(category);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question ) {
		
		return qs.addQuestion(question);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteQuestionById(@PathVariable("id") int id) {
		qs.deleteQuestionById(id);
		return "success";
	}
	
}
