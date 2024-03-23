package com.example.demo.service;

import com.example.demo.model.Question;

import java.util.Collection;
import java.util.List;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
