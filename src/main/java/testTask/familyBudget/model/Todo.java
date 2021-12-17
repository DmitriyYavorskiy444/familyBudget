package testTask.familyBudget.model;

import lombok.Getter;
import lombok.Setter;
import testTask.familyBudget.entity.TodoEntity;

@Getter
@Setter
public class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    public static Todo toModel(TodoEntity entity) {
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setTitle(entity.getTitle());
        return model;
    }

    public Todo() {
    }
}
