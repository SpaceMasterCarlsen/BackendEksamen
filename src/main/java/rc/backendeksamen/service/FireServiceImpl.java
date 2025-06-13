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

    private static final int EARTH_RADIUS_KM = 6371;
    public static double calculateDistanceKM(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS_KM * c;
    }

}
