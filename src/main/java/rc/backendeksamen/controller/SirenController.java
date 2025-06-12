package rc.backendeksamen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rc.backendeksamen.model.Fire;
import rc.backendeksamen.model.Siren;
import rc.backendeksamen.service.SirenService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SirenController {

    @Autowired
    SirenService sirenService;

    @GetMapping("/siren")
    public ResponseEntity<List<Siren>> getAllSirens(){
        List<Siren> sirens = sirenService.findAll();
        if(sirens.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(sirens);
        }
    }

    @GetMapping("/siren/{id}")
    public ResponseEntity<Siren> getSirenById(@PathVariable long id){
        Optional<Siren> orgSiren = sirenService.findById(id);
        if(orgSiren.isPresent()){
            return ResponseEntity.ok(orgSiren.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/siren")
    public ResponseEntity<String> postSiren(@RequestBody Siren siren){
        sirenService.save(siren);
        return ResponseEntity.status(HttpStatus.CREATED).body("Siren created");
    }

    @PutMapping("/siren/{id}")
    public ResponseEntity<Siren> updateSirenById(@PathVariable long id, @RequestBody Siren siren){
        return sirenService.findById(id).map(exiting -> {
            exiting.setOperationalStatus(siren.getOperationalStatus());
            exiting.setIsInWorkingCondition(siren.isInWorkingCondition());
            exiting.setLatitude(siren.getLatitude());
            exiting.setLongitude(siren.getLongitude());
            Siren updated = sirenService.save(exiting);
            return ResponseEntity.ok(updated);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/siren/{id}")
    public ResponseEntity<String> deleteSirenById(@PathVariable long id){
        Optional<Siren> orgSiren = sirenService.findById(id);
        if(orgSiren.isPresent()){
            Siren siren = orgSiren.get();
            for(Fire fire : siren.getFireHistory()){
                fire.getActivatedSirens().remove(siren);
            }
            sirenService.deleteById(id);
            return ResponseEntity.ok().body("Siren deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
