package com.javaTest.questionBank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class QuestionController {
	
	@Autowired
	QuestionService qs;
	
	
	@GetMapping("/questions")
	public List<Question> questions() {
		
		return qs.getAllQuestion();
	}
	
}
