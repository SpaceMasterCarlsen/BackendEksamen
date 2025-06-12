package rc.backendeksamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rc.backendeksamen.model.Fire;
import rc.backendeksamen.repository.FireRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FireServiceImpl implements FireService {

    @Autowired
    FireRepository repository;

    @Override
    public List<Fire> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Fire> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public Fire save(Fire siren) {
        return repository.save(siren);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
