package GOSharpner.DataByGoSharpner.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "AssociatedDrugs")
public class AssociatedDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dose;
    private String strength;

    @ManyToOne
    @JoinColumn(name = "class_name_id")
    private ClassName className;

    private boolean isSecondary;

    // getters and setters
}