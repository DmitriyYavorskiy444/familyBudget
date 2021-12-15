package testTask.familyBudget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testTask.familyBudget.entity.UserEntity;
import testTask.familyBudget.exception.UserAlreadyExistException;
import testTask.familyBudget.exception.UserNotFoundException;
import testTask.familyBudget.model.User;
import testTask.familyBudget.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findByUserName(user.getUserName()) != null) {
            throw new UserAlreadyExistException("The user with the same name already exists. Please change a name.");
        }
        return userRepository.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User is not found. Please check your ID.");
        }
        return User.toModel(user);
    }
}
