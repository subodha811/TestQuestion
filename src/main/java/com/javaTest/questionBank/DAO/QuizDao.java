package com.javaTest.questionBank.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.javaTest.questionBank.Model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

	

	
}
