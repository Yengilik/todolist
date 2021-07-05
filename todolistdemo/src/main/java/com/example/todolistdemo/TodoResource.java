package com.example.todolistdemo;

import com.example.todolistdemo.models.TodoItem;
import com.example.todolistdemo.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoitem")
public class TodoResource {
    private final TodoService todoService;

    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TodoItem>> getAll(){
        List<TodoItem> todos = todoService.findAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TodoItem> getById(@PathVariable("id") Long id){
        TodoItem todo = todoService.findTodoItemById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TodoItem> add(@RequestBody TodoItem todoItem){
        TodoItem newTodo = todoService.addTodoItem(todoItem);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TodoItem> update(@RequestBody TodoItem todoItem){
        TodoItem updateTodoItem = todoService.updateTodoItem(todoItem);
        return new ResponseEntity<>(updateTodoItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        todoService.deleteTodoItem(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping("/done/{id}")
    public ResponseEntity<?> done(@PathVariable("id") Long id){
        todoService.isDone(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
