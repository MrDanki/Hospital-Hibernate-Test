package com.stucom.Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nurse")
public class NurseController {

    private static final Logger logger = LoggerFactory.getLogger(NurseController.class);

    private final List<Nurse> nurses = new ArrayList<>(List.of(
            new Nurse(1, "Maria Lopez", "maria", "1234"),
            new Nurse(2, "Juan Perez", "juan", "abcd"),
            new Nurse(3, "Ana Garcia", "ana", "pass"),
            new Nurse(4, "Maria Torres", "mtorres", "0000")));

    @GetMapping("/index")
    public ResponseEntity<List<Nurse>> getAll() {
        return ResponseEntity.ok(nurses);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Nurse inputNurse) {
        boolean ok = nurses.stream()
                .anyMatch(n -> Objects.equals(n.getUser(), inputNurse.getUser())
                        && Objects.equals(n.getPassword(), inputNurse.getPassword()));

        if (ok) {
            return ResponseEntity.ok(true);
        }

        logger.warn("Error in login");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Nurse> findByName(@PathVariable String name) {
        Optional<Nurse> result = nurses.stream()
                .filter(n -> n.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst();

        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}