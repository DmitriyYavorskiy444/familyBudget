package testTask.familyBudget.repository;

import org.springframework.data.repository.CrudRepository;
import testTask.familyBudget.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUserName(String userName); //to be attentive about name of this variable

}
