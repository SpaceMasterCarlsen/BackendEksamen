package rc.backendeksamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rc.backendeksamen.model.Siren;
import rc.backendeksamen.repository.SirenRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SirenServiceImpl implements SirenService{

    @Autowired
    SirenRepository repository;


    @Override
    public List<Siren> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Siren> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public Siren save(Siren siren) {
        return repository.save(siren);
    }

    @Override
    public void deleteById(long id) {

    }
}
