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
	
	public List<Question> getQuestionByCategory(String category) {
		
		return qd.findByCategory(category);
	}

	public void deleteQuestionById(int id) {
		qd.deleteById((Integer)id);
		
	}

	public void addQuestion(Question question) {
		qd.save(question);
		
	}
}
