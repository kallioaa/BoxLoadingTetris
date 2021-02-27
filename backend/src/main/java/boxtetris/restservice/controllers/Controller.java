package boxtetris.restservice.controllers;

import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import boxtetris.entities.Container;
import boxtetris.entities.Pattern;
import boxtetris.entities.Cuboid;
import boxtetris.restservice.models.LayerBuilderSettings;
import boxtetris.restservice.models.PatternJSON;
import boxtetris.restservice.services.Services;

@RestController
public class Controller {

    @Autowired
    private Services service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getCuboids")
    public ResponseEntity<ArrayList<Cuboid>> getCuboids() {
        ArrayList<Cuboid> cuboids = service.getCuboids();
        return ResponseEntity.ok().body(cuboids);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getContainers")
    public ResponseEntity<ArrayList<Container>> getContainers() {
        ArrayList<Container> containers = service.getContainers();
        return ResponseEntity.ok().body(containers);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/generatePatterns")
    public ResponseEntity<String> generatePatterns(@RequestBody LayerBuilderSettings layerBuilderSettings) {
        service.generatePatterns(layerBuilderSettings.getCuboidsInRow(), layerBuilderSettings.getRowsInLayer());
        return ResponseEntity.ok().body("Pattern generated successfully!");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getPatterns")
    public ResponseEntity<ArrayList<PatternJSON>> getPatterns() {
        ArrayList<PatternJSON> patterns = service.getPatterns();
        return ResponseEntity.ok().body(patterns);
    }

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
