package com.springboottodoapplication.config;

import com.springboottodoapplication.models.TodoItem;
import com.springboottodoapplication.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    final TodoItemRepository todoItemRepository;

    public TodoItemDataLoader(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    private void loadData() {
        if(todoItemRepository.count() == 0){
            TodoItem todoItem1 = new TodoItem("create a todo list");
            TodoItem todoItem2 = new TodoItem("post it on GitHub");
            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
        }
        logger.info("Number of TodoItems: {}", todoItemRepository.count());
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }
}
