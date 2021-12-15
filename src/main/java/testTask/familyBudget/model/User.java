package testTask.familyBudget.model;

import lombok.Getter;
import lombok.Setter;
import testTask.familyBudget.entity.UserEntity;

@Getter
@Setter
public class User {
    private Long id;
    private String userName;
    private String role;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUserName(entity.getUserName());
        model.setRole(entity.getRole());
        return model;
    }

    public User() {
    }
}
