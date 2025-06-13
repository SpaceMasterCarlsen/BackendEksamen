package rc.backendeksamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rc.backendeksamen.model.Fire;

import java.util.List;

public interface FireRepository extends JpaRepository<Fire, Long> {
    List<Fire> findByStatusTrue();
}
