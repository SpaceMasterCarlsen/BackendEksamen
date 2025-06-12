package rc.backendeksamen.service;

import rc.backendeksamen.model.Siren;

import java.util.List;
import java.util.Optional;

public interface SirenService {
    List<Siren> findAll();
    Optional<Siren> findById(long id);
    Siren save(Siren siren);
    void deleteById(long id);
}
