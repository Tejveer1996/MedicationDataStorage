package GOSharpner.DataByGoSharpner.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MedicationClasses")
public class MedicationClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    private Medication medication;

    @OneToMany(mappedBy = "medicationClass", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ClassName> classNames;

    // getters and setters
}