package testTask.familyBudget.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import testTask.familyBudget.entity.TodoEntity;

@Data
@NoArgsConstructor
public class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    public static Todo toModel(TodoEntity entity) {
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setCompleted(entity.getCompleted());
        return model;
    }

}
