package testTask.familyBudget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testTask.familyBudget.entity.FamilyEntity;
import testTask.familyBudget.entity.UserEntity;
import testTask.familyBudget.exception.UserAlreadyExistException;
import testTask.familyBudget.exception.UserNotFoundException;
import testTask.familyBudget.model.User;
import testTask.familyBudget.repository.FamilyRepository;
import testTask.familyBudget.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FamilyRepository familyRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findByUserName(user.getUserName()) != null) {
            throw new UserAlreadyExistException("The user with the same name already exists. Please change a name.");
        }
        return userRepository.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User is not found. Please check your ID.");
        }
        return User.toModel(user);
    }

//    public List<UserEntity> getAll() throws UserNotFoundException {
//        return userRepository.findAll();
//    }

    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }

    public User createUser(UserEntity user, Long familyId) {
        FamilyEntity family = familyRepository.findById(familyId).get();
        user.setFamily(family);
        return User.toModel(userRepository.save(user));
    }

}
