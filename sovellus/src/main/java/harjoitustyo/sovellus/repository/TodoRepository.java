package harjoitustyo.sovellus.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import harjoitustyo.sovellus.model.ToDo;

@Repository
public class TodoRepository {

    private final Map<Long, ToDo> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    // Luo tai päivitä Todo
    public ToDo save(ToDo todo) {
        if (todo.getId() == null) {
            todo.setId(idGenerator.incrementAndGet());
        }
        storage.put(todo.getId(), todo);
        return todo;
    }

    // Hae kaikki
    public List<ToDo> findAll() {
        return new ArrayList<>(storage.values());
    }

    // Hae id:llä
    public Optional<ToDo> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    // Poista id:llä
    public void delete(Long id) {
        storage.remove(id);
    }
}
