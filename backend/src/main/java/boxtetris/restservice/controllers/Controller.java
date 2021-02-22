package boxtetris.restservice.controllers;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import boxtetris.entities.Container;
import boxtetris.entities.Cuboid;
import boxtetris.restservice.services.Services;

@RestController
public class Controller {

    @Autowired
    private Services service;

    // @GetMapping("/createPattern")
    // public ResponseEntity<> createPattern() {
    //
    // }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addCuboid")
    public ResponseEntity<String> addCuboid(@RequestBody Cuboid cuboid) throws URISyntaxException {
        service.createCuboid(cuboid);
        return ResponseEntity.ok().body("Cuboid Added!");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addContainer")
    public ResponseEntity<String> addContainer(@RequestBody Container container) throws URISyntaxException {
        service.createContainer(container);
        return ResponseEntity.ok().body("Container Added!");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/clearCuboids")
    public ResponseEntity<String> clearCuboids() throws URISyntaxException {
        service.clearCuboids();
        return ResponseEntity.ok().body("Cuboids have been cleared!");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/clearContainers")
    public ResponseEntity<String> clearContainers() throws URISyntaxException {
        service.clearContainers();
        return ResponseEntity.ok().body("Containers have been cleared!");
    }

}
