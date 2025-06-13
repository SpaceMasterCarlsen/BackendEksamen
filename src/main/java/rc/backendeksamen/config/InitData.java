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
        List<Siren> sirens = List.of(
                new Siren("Santa Monica Pier", true, true, 34.0094, -118.4973),
                new Siren("Ocean Ave & Colorado", true, true, 34.0119, -118.4951),
                new Siren("Montana Ave Park", true, true, 34.0342, -118.5013),
                new Siren("Palisades Park South", true, true, 34.0082, -118.4975),
                new Siren("San Vicente Blvd", true, true, 34.0358, -118.5120),
                new Siren("Pacific Palisades Center", true, true, 34.0505, -118.5260),
                new Siren("Temescal Canyon", true, true, 34.0490, -118.5290),
                new Siren("Will Rogers State Beach", true, true, 34.0305, -118.5336),
                new Siren("Sunset Blvd Entrance", true, true, 34.0497, -118.5184),
                new Siren("Santa Monica High", true, true, 34.0100, -118.4850),
                new Siren("Venice Border", true, false, 33.9994, -118.4731),
                new Siren("4th & Arizona", false, true, 34.0185, -118.4927),
                new Siren("Brentwood Park", true, true, 34.0633, -118.4910),
                new Siren("Rustic Canyon", true, false, 34.0473, -118.5201),
                new Siren("Santa Monica College", false, true, 34.0172, -118.4702)
        );
        sirenRepository.saveAll(sirens);
        List<Fire> fires = List.of(
                new Fire("Brush Fire PCH", LocalDateTime.now().minusHours(1), true, 34.0350, -118.5300),
                new Fire("Canyon Fire", LocalDateTime.now().minusMinutes(30), true, 34.0510, -118.5250),
                new Fire("Venice Trash Fire", LocalDateTime.now().minusMinutes(45), true, 33.9970, -118.4700),
                new Fire("Pier Incident", LocalDateTime.now().minusMinutes(10), true, 34.0090, -118.4960),
                new Fire("Downtown Santa Monica Smoke", LocalDateTime.now().minusMinutes(20), true, 34.0190, -118.4910),
                new Fire("Montana Hillside", LocalDateTime.now().minusHours(2), true, 34.0330, -118.5030),
                new Fire("Pacific View Fire", LocalDateTime.now().minusMinutes(5), true, 34.0520, -118.5210),
                new Fire("Sunset Bluff Blaze", LocalDateTime.now().minusHours(3), true, 34.0460, -118.5180)
        );
        fireRepository.saveAll(fires);

    }
}
