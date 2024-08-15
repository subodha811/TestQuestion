package com.javaTest.questionBank.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaTest.questionBank.DAO.QuestionDao;
import com.javaTest.questionBank.Model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao qd;

	public ResponseEntity<List<Question>> getAllQuestion() {
		try {
			return new ResponseEntity<>(qd.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<Question>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
			return new ResponseEntity<List<Question>>(qd.findByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public void deleteQuestionById(int id) {
		qd.deleteById((Integer) id);

	}

	public ResponseEntity<String> addQuestion(Question question) {
		qd.save(question);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
}
