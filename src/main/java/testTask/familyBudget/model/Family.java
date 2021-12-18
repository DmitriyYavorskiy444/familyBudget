package testTask.familyBudget.model;

import lombok.Getter;
import lombok.Setter;
import testTask.familyBudget.entity.FamilyEntity;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Family {
    private Long id;
    private String familyName;
    private BigDecimal balance;
    private List<User> users;


    public static Family toModel(FamilyEntity entity){
        Family model = new Family();
        model.setId(entity.getId());
        model.setFamilyName(entity.getFamilyName());
        model.setBalance(entity.getBalance());
        model.setUsers(entity.getMembers().stream().map(User::toModel).collect(Collectors.toList()));
        return model;
    }
    public Family() {
    }
}
