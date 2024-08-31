package GOSharpner.DataByGoSharpner.Repository;

import GOSharpner.DataByGoSharpner.Entity.AssociatedDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociatedDrugRepository extends JpaRepository<AssociatedDrug,Integer> {
}
