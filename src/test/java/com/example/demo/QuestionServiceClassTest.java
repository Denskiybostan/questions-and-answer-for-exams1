package com.example.demo;

import com.example.demo.exceptions.NotFoundQuestionsException;
import com.example.demo.model.Question;
import com.example.demo.service.QuestionServiceClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceClassTest {
    @Mock
    @InjectMocks
    QuestionServiceClass service;

    @BeforeEach
    void setUp() {
        when(service.getAll()).thenReturn(List.of(
                new Question("test1","answer2"),
                new Question("test2","answer3"),
                new Question("test3","answer4")));
    }
    @Test
    void testRandomQuestion() {

    }
    @Test
    void testEmptyQuestions() {
        when(service.getAll()).thenReturn(List.of());


        assertThrows(NotFoundQuestionsException.class, () -> service.getRandomQuestion());

    }
}
