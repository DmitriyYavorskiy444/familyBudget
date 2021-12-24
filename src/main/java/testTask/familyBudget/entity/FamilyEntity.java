package testTask.familyBudget.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "familyApi")
public class FamilyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String familyName;
    private BigDecimal balance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "family")
    @JsonIgnore
    private List<UserEntity> members;

}
