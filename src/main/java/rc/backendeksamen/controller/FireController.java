package rc.backendeksamen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import rc.backendeksamen.service.FireService;

@RestController
public class FireController {

    @Autowired
    FireService fireService;
}
