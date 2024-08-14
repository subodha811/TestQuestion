package com.javaTest.questionBank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{
 
	List<Question> findByCategory(String str);
	
	
}
