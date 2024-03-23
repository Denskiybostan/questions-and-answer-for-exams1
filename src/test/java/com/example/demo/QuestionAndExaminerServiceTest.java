package com.example.demo;

import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;
import com.example.demo.service.QuestionServiceClass;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionAndExaminerServiceTest {
    QuestionServiceClass service = new QuestionServiceClass();
    @Test
    void testAdd() {
        service.add(new Question("test1", "answer2"));
        service.add("test1", "answer3");

        assertThat(service.getAll()).containsExactlyInAnyOrder(
                new Question("question", "answer"),
                new Question("question1", "answer2"));
    }

    @Test
    void testRemove() {
        service.add(new Question("test2", "answer2"));
        service.add("test1", "answer3");

        var removed = service.remove(new Question("test2", "answer12"));
        assertThat(removed).isEqualTo(new Question("test2", "answer12"));

        var empty = service.remove(new Question("vdsv", "fdb"));
        assertThat(empty).isNull();

        assertThat(service.getAll()).containsExactlyInAnyOrder(
                new Question("question", "answer"),
                new Question("question1", "answer2"));
    }
}
