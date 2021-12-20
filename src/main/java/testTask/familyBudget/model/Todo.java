package testTask.familyBudget.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import testTask.familyBudget.entity.TodoEntity;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Todo {
    private Long id;
    private String title; //withdrawal or replenishment
    private BigDecimal transaction;
    private Boolean completed;

    public static Todo toModel(TodoEntity entity) {
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setTransaction(entity.getTransaction());
        model.setCompleted(entity.getCompleted());
        return model;
    }

}
