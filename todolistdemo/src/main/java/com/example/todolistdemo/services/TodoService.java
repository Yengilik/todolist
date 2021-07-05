package com.example.todolistdemo.services;

import com.example.todolistdemo.exception.UserNotFoundException;
import com.example.todolistdemo.models.TodoItem;
import com.example.todolistdemo.repos.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    private final TodoRepo todoRepo;

    @Autowired
    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    public TodoItem addTodoItem(TodoItem todo){
        return  todoRepo.save(todo);

    }

    public List<TodoItem> findAllTodos(){
        return  todoRepo.findAll();
    }

    public TodoItem updateTodoItem(TodoItem todo){
        return todoRepo.save(todo);
    }

    public TodoItem findTodoItemById(Long id){
        return todoRepo.findTodoItemById(id)
                .orElseThrow(() -> new UserNotFoundException("User byd id " + id + " was not found"));

    }

    public void deleteTodoItem(Long id){
        todoRepo.deleteTodoItemById(id);
    }
    public void isDone(Long id){
        todoRepo.isDone(id);
    }
}
