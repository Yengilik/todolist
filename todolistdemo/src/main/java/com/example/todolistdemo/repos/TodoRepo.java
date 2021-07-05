package com.example.todolistdemo.repos;

import com.example.todolistdemo.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepo extends JpaRepository<TodoItem,Long> {
    void deleteTodoItemById(Long id);
    Optional<TodoItem> findTodoItemById(Long id);
    void isDone(long id);
}
