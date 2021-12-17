package testTask.familyBudget.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class FamilyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String familyName;
    private BigDecimal balance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "family")
    private List<UserEntity> members;

    public FamilyEntity() {
    }
}
