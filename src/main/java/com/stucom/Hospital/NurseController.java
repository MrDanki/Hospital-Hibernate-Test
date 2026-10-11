package com.stucom.Hospital;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class NurseController{
	@Autowired
    private NurseRepository nurseRepository;
	
	@PostMapping("/login")
    public @ResponseBody ResponseEntity<Boolean> login(@RequestBody Nurse inputNurse) {
    Optional<Nurse> nurseLogin = nurseRepository.findByUserAndPassword(
        inputNurse.getUser(), inputNurse.getPassword()
    );

    if (nurseLogin.isPresent()) {
        return ResponseEntity.ok(true);
    }

 //   Logger.warn("Error in login");
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
    }
@GetMapping("/nurse/name/{name}")
public Nurse findByName(@PathVariable String name) {
	Optional<Nurse> nurse=nurseRepository.findByName(name);
	return nurse.orElse(null);
}
}