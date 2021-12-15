package testTask.familyBudget.model;

import testTask.familyBudget.entity.UserEntity;

public class User {
    private Long id;
    private String userName;
    private String role;

    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setUserName(entity.getUserName());
        model.setRole(entity.getRole());
        return model;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
