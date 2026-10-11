package com.stucom.Hospital;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

@Repository
public class NurseRepository {

    private final List<Nurse> nurses;

    public NurseRepository(JsonMapper jsonMapper) throws IOException {
        nurses = jsonMapper.readValue(new ClassPathResource("nurses.json").getInputStream(),
                new TypeReference<List<Nurse>>() {});
    }

    public Optional<Nurse> findByName(String name) {
        return nurses.stream()
                .filter(n -> n.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public Optional<Nurse> findByUserAndPassword(String user, String password) {
        return nurses.stream()
                .filter(n -> n.getUser().equals(user) && n.getPassword().equals(password))
                .findFirst();
    }
}