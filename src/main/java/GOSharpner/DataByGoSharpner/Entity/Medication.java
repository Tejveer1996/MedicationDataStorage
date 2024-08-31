package GOSharpner.DataByGoSharpner.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Medications")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<MedicationClass> medicationClasses;

    // getters and setters
}
