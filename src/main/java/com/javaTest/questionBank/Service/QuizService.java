package com.javaTest.questionBank.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaTest.questionBank.DAO.QuestionDao;
import com.javaTest.questionBank.DAO.QuizDao;
import com.javaTest.questionBank.Model.Question;
import com.javaTest.questionBank.Model.QuestionWapper;
import com.javaTest.questionBank.Model.Quiz;

@Service
public class QuizService {
	@Autowired
	QuestionDao questiondao;
	@Autowired
	QuizDao quizDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Question> questions = questiondao.findRandomQuestionsByCategory(category, numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWapper>> getQuiz(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> queFromDb = quiz.get().getQuestions();
		List<QuestionWapper> queForUser= new ArrayList<>();
		for (Question q : queFromDb) {
			QuestionWapper questionwrapper =  new QuestionWapper( q.getQid(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			queForUser.add(questionwrapper);
			
		}
		return new ResponseEntity<>(queForUser,HttpStatus.OK);
	}

}
