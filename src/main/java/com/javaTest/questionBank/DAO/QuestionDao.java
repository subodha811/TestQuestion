package com.javaTest.questionBank.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaTest.questionBank.Model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{
 
	List<Question> findByCategory(String str);

	@Query(value = "SELECT * FROM Question q WHERE q.category = :category ORDER BY DBMS_RANDOM.VALUE FETCH FIRST :numQ ROWS ONLY", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, int numQ);
	
	
}
