package testTask.familyBudget.repository;

import org.springframework.data.repository.CrudRepository;
import testTask.familyBudget.entity.FamilyEntity;

public interface FamilyRepository extends CrudRepository<FamilyEntity, Long> {
    FamilyEntity findByFamilyName(String familyName); //to be attentive about name of this variable
}
