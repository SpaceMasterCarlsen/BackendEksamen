package rc.backendeksamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rc.backendeksamen.model.Fire;

public interface FireRepository extends JpaRepository<Fire, Long> {
}
