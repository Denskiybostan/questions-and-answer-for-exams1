package com.example.demo.service;

import com.example.demo.exceptions.NotFoundQuestionsException;
import com.example.demo.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class QuestionServiceClass implements QuestionService {
    private final Set<Question> storage = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        storage.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (storage.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(storage);
    }
    @Override
    public Question getRandomQuestion() {
        var index = random.nextInt(storage.size());
        var i = 0;
        for (Question question : storage) {
            if (index == i) {
                return question;
            }
            i++;
        }
        throw new NotFoundQuestionsException();
    }
}
