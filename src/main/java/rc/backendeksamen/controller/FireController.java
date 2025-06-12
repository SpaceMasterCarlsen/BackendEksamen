package rc.backendeksamen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rc.backendeksamen.model.Fire;
import rc.backendeksamen.repository.FireRepository;
import rc.backendeksamen.service.FireService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class FireController {

    @Autowired
    FireService fireService;

    @Autowired
    FireRepository fireRepository;

    @GetMapping("/fire")
    public ResponseEntity<List<Fire>> getAllFires(){
        List<Fire> fires = fireRepository.findAll();
        if(fires.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(fires);
        }
    }

    @GetMapping("/fire/{id}")
    public ResponseEntity<Fire> getFireById(@PathVariable long id){
        Optional<Fire> orgFire = fireRepository.findById(id);
        if(orgFire.isPresent()){
            return ResponseEntity.ok(orgFire.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
