package com.javaTest.questionBank.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaTest.questionBank.DAO.QuestionDao;
import com.javaTest.questionBank.DAO.QuizDao;
import com.javaTest.questionBank.Model.Question;
import com.javaTest.questionBank.Model.Quiz;

@Service
public class QuizService {
	@Autowired
	QuestionDao questiondao;
	@Autowired
	QuizDao quizDao;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Question> questions= questiondao.findRandomQuestionsByCategory(category,numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<String>("Success",HttpStatus.CREATED);
	}

	
}
