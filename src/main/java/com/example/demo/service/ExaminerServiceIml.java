package com.example.demo.service;

import com.example.demo.exceptions.NotEnoughQuestionException;
import com.example.demo.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExaminerServiceIml implements  ExaminerService {
    public final QuestionService questionService;

    public ExaminerServiceIml(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount){
        var allQuestions = questionService.getAll();
        if (amount > allQuestions.size()) {
            throw new NotEnoughQuestionException();
        }
        if (amount == questionService.getAll().size()) {
            return allQuestions;
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }

        return questions;
    }

}
