package testTask.familyBudget.model;

import lombok.Getter;
import lombok.Setter;
import testTask.familyBudget.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class User {
    private Long id;
    private String userName;
    private String role;
    private List<Todo> todos;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUserName(entity.getUserName());
        model.setRole(entity.getRole());
        model.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList())); //transform an array of entity into array of models
        return model;
    }

    public User() {
    }
}
