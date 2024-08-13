package com.javaTest.questionBank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

	@Autowired
	QuestionDao qd; 
	public List<Question> getAllQuestion() {
		return qd.findAll();
	}
}
