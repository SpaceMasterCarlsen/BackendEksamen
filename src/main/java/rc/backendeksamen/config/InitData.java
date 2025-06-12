package rc.backendeksamen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rc.backendeksamen.model.Fire;
import rc.backendeksamen.model.Siren;
import rc.backendeksamen.repository.FireRepository;
import rc.backendeksamen.repository.SirenRepository;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    FireRepository fireRepository;
    @Autowired
    SirenRepository sirenRepository;

    @Override
    public void run(String... args) throws Exception{
        Fire f1 = new Fire();
        f1.setStatus("Active");
        f1.setTimestamp(LocalDateTime.of(2020, 1, 10, 0, 0));
        f1.setLatitude(55.69212);
        f1.setLongitude(12.55637);
        Siren siren = new Siren();
        siren.setStatus("Activated");
        siren.setIsInWorkingCondition(true);
        siren.setLatitude(55.69212);
        siren.setLongitude(12.55637);
        Fire f2 = new Fire();
        f2.setStatus("Active");
        f2.setTimestamp(LocalDateTime.of(2022, 2, 22, 0, 0));
        f2.setLatitude(55.69212);
        f2.setLongitude(12.55637);
        Siren siren2 = new Siren();
        siren2.setStatus("Activated");
        siren2.setIsInWorkingCondition(true);
        siren2.setLatitude(55.69212);
        siren2.setLongitude(12.55637);
        sirenRepository.save(siren);
        sirenRepository.save(siren2);
        f1.setActivatedSirens(List.of(siren, siren2));
        siren.setFireHistory(List.of(f1, f1));
        fireRepository.save(f1);
        fireRepository.save(f2);

    }
}
