package GOSharpner.DataByGoSharpner.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ClassNames")
public class ClassName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;

    @ManyToOne
    @JoinColumn(name = "medication_class_id")
    private MedicationClass medicationClass;

    @OneToMany(mappedBy = "className", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<AssociatedDrug> associatedDrugs;

    // getters and setters
}