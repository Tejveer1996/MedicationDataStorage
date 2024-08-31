package GOSharpner.DataByGoSharpner.Repository;

import GOSharpner.DataByGoSharpner.Entity.MedicationClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationClassRepository extends JpaRepository<MedicationClass,Long> {
}
