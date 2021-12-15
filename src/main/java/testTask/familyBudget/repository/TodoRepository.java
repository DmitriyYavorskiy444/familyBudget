package testTask.familyBudget.repository;

import org.springframework.data.repository.CrudRepository;
import testTask.familyBudget.entity.TodoEntity;

public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
}
