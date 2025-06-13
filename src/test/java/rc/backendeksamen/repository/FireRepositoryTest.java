package rc.backendeksamen.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import rc.backendeksamen.model.Fire;
import rc.backendeksamen.model.Siren;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FireRepositoryTest {

    @Autowired
    private FireRepository fireRepository;

    @Autowired
    private SirenRepository sirenRepository;

    @Test
    void saveAndFindFire() {
        Fire fire = new Fire("Testbrand", LocalDateTime.now(), true, 34.0, -118.0);
        fireRepository.save(fire);

        List<Fire> allFires = fireRepository.findAll();
        assertThat(allFires).hasSize(1);
        assertThat(allFires.get(0).getName()).isEqualTo("Testbrand");
    }

    @Test
    void findActiveFires() {
        fireRepository.save(new Fire("Brand1", LocalDateTime.now(), true, 34.0, -118.0));
        fireRepository.save(new Fire("Brand2", LocalDateTime.now(), false, 34.1, -118.1));

        List<Fire> activeFires = fireRepository.findByStatusTrue();
        assertThat(activeFires).hasSize(1);
        assertThat(activeFires.get(0).getName()).isEqualTo("Brand1");
    }

    @Test
    void saveFireWithSirens() {
        Siren siren1 = new Siren("Siren A", true, true, 34.001, -118.001);
        Siren siren2 = new Siren("Siren B", true, true, 34.002, -118.002);
        sirenRepository.saveAll(List.of(siren1, siren2));

        Fire fire = new Fire("Brand med sirener", LocalDateTime.now(), true, 34.005, -118.005);
        fire.setActivatedSirens(List.of(siren1, siren2));
        fireRepository.save(fire);

        Fire found = fireRepository.findById(fire.getId()).orElseThrow();
        assertThat(found.getActivatedSirens()).hasSize(2);
    }

}