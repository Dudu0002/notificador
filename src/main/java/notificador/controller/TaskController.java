package notificador.controller;

import notificador.model.Task;
import notificador.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Task criar(@RequestBody Task task) {
        return repository.save(task);
    }

    @GetMapping
    public List<Task> listar() {
        return repository.findAll();
    }
}