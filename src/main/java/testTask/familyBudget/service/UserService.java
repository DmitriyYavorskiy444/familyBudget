package testTask.familyBudget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testTask.familyBudget.entity.FamilyEntity;
import testTask.familyBudget.entity.UserEntity;
import testTask.familyBudget.exception.AlreadyExistException;
import testTask.familyBudget.exception.NotFoundException;
import testTask.familyBudget.model.User;
import testTask.familyBudget.repository.FamilyRepository;
import testTask.familyBudget.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FamilyRepository familyRepository;

    public UserEntity registration(UserEntity user) throws AlreadyExistException {
        if (userRepository.findByUserName(user.getUserName()) != null) {
            throw new AlreadyExistException("The user with the same name already exists. Please change a name.");
        }
        return userRepository.save(user);
    }

    public UserEntity createUser(UserEntity user, Long familyId) throws AlreadyExistException {
        if (userRepository.findByUserName(user.getUserName()) != null) {
            throw new AlreadyExistException("The user with the same name already exists. Please change a name.");
        }
        FamilyEntity family = familyRepository.findById(familyId).get();
        user.setFamily(family);
        return userRepository.save(user);
    }

    public User getOne(Long id) throws NotFoundException {
        UserEntity user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException("User is not found. Please check your ID.");
        }
        return User.toModel(user);
    }

    public List<User> getAll() throws IllegalArgumentException {
        List<User> allUsers = new ArrayList<>();
        Iterable<UserEntity> entities = userRepository.findAll();
        for (UserEntity userEntity : entities) {
            allUsers.add(User.toModel(userEntity));
        }
        return allUsers;
    }

    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }

}
