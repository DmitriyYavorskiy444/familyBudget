package testTask.familyBudget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testTask.familyBudget.entity.FamilyEntity;
import testTask.familyBudget.entity.UserEntity;
import testTask.familyBudget.exception.AlreadyExistException;
import testTask.familyBudget.exception.NotFoundException;
import testTask.familyBudget.model.Family;
import testTask.familyBudget.model.User;
import testTask.familyBudget.repository.FamilyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    public FamilyEntity registration(FamilyEntity family) throws AlreadyExistException {
        if (familyRepository.findByFamilyName(family.getFamilyName()) != null) {
            throw new AlreadyExistException("The family with the same name already exists. Please change a name.");
        }
        return familyRepository.save(family);
    }

    public Family getOne(Long id) throws NotFoundException {
        FamilyEntity family = familyRepository.findById(id).orElse(null);
        if (family == null) {
            throw new NotFoundException("Family is not found. Please check your ID.");
        }
        return Family.toModel(family);
    }

    public List<Family> getAll() throws IllegalArgumentException {
        List<Family> allFamilies = new ArrayList<>();
        Iterable<FamilyEntity> entities = familyRepository.findAll();
        for (FamilyEntity familyEntity : entities) {
            allFamilies.add(Family.toModel(familyEntity));
        }
        return allFamilies;
    }

    public Long delete(Long id) {
        familyRepository.deleteById(id);
        return id;
    }

}
