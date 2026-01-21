package harjoitustyo.sovellus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import harjoitustyo.sovellus.model.ToDo;
import harjoitustyo.sovellus.repository.TodoRepository;

@Service
public class ToDoService {

    private final TodoRepository repository;

    public ToDoService(TodoRepository repository) {
        this.repository = repository;
    }

    public ToDo create(ToDo todo) {
        return repository.save(todo);
    }

    public List<ToDo> getAll() {
        return repository.findAll();
    }

    public ToDo getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDo not found"));
    }

    public ToDo update(Long id, ToDo updated) {
        ToDo existing = getById(id);
        existing.setTitle(updated.getTitle());
        existing.setCompleted(updated.isCompleted());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
