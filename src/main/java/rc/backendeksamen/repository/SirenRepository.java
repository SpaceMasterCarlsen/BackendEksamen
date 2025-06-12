package rc.backendeksamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rc.backendeksamen.model.Siren;

public interface SirenRepository extends JpaRepository<Siren, Long> {
}
