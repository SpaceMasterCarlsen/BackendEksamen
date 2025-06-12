package rc.backendeksamen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rc.backendeksamen.model.Fire;
import rc.backendeksamen.model.Siren;
import rc.backendeksamen.service.FireService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class FireController {

    @Autowired
    FireService fireService;

    @GetMapping("/fire")
    public ResponseEntity<List<Fire>> getAllFires(){
        List<Fire> fires = fireService.findAll();
        if(fires.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(fires);
        }
    }

    @GetMapping("/fire/{id}")
    public ResponseEntity<Fire> getFireById(@PathVariable long id){
        Optional<Fire> orgFire = fireService.findById(id);
        if(orgFire.isPresent()){
            return ResponseEntity.ok(orgFire.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/fire")
    public ResponseEntity<String> postFire(@RequestBody Fire fire){
        fireService.save(fire);
        return ResponseEntity.status(HttpStatus.CREATED).body("Fire created");
    }

    @PutMapping("/fire/{id}")
    public ResponseEntity<Fire> updateFireById(@PathVariable long id, @RequestBody Fire fire){
        return fireService.findById(id).map(exiting -> {
            exiting.setTimestamp(fire.getTimestamp());
            exiting.setStatus(fire.getStatus());
            exiting.setLatitude(fire.getLatitude());
            exiting.setLongitude(fire.getLongitude());
            Fire updated = fireService.save(exiting);
            return ResponseEntity.ok(updated);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/fire/{id}")
    public ResponseEntity<String> deleteFireById(@PathVariable long id){
        Optional<Fire> orgFire = fireService.findById(id);
        if(orgFire.isPresent()){
            Fire fire = orgFire.get();
            for(Siren siren : fire.getActivatedSirens()){
                siren.getFireHistory().remove(fire);
            }
            fireService.deleteById(id);
            return ResponseEntity.ok().body("Fire deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
