package GOSharpner.DataByGoSharpner.Repository;

import GOSharpner.DataByGoSharpner.Entity.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassNameRepository extends JpaRepository<ClassName,Long> {
}
