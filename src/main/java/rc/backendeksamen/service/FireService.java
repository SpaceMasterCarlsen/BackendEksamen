package rc.backendeksamen.service;

import rc.backendeksamen.model.Fire;

import java.util.List;
import java.util.Optional;

public interface FireService {
    List<Fire> findAll();
    Optional<Fire> findById(long id);
    Fire save(Fire siren);
    void deleteById(long id);
}
