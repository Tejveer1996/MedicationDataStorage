package GOSharpner.DataByGoSharpner.Repository;

import GOSharpner.DataByGoSharpner.Entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
