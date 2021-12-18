package testTask.familyBudget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testTask.familyBudget.entity.FamilyEntity;
import testTask.familyBudget.entity.UserEntity;
import testTask.familyBudget.exception.UserAlreadyExistException;
import testTask.familyBudget.exception.UserNotFoundException;
import testTask.familyBudget.model.Family;
import testTask.familyBudget.model.User;
import testTask.familyBudget.repository.FamilyRepository;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    public FamilyEntity registration(FamilyEntity family) throws UserAlreadyExistException {
        if (familyRepository.findByFamilyName(family.getFamilyName()) != null) {
            throw new UserAlreadyExistException("The family with the same name already exists. Please change a name.");
        }
        return familyRepository.save(family);
    }

    public Family getOne(Long id) throws UserNotFoundException {
        FamilyEntity family = familyRepository.findById(id).orElse(null);
        if (family == null) {
            throw new UserNotFoundException("User is not found. Please check your ID.");
        }
        return Family.toModel(family);
    }

//    public List<UserEntity> getAll() throws UserNotFoundException {
//        return userRepository.findAll();
//    }

    public Long delete(Long id) {
        familyRepository.deleteById(id);
        return id;
    }

}
