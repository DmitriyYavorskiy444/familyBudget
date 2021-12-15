package testTask.familyBudget.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class FamilyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String familyName;
    private Long balance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserEntity> users;

    public FamilyEntity() {
    }
}
