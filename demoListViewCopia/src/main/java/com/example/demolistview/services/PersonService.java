package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    PersonFileRepository repo = new PersonFileRepository();
    public List<String> loadDataForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();



        for(String line : lines){
            if (line == null || line.isBlank()){
                continue;
            }
            String[] parts = line.split(",");
            String name = parts[0];
            String email = parts[1];
            result.add("Nombre : " + name + " - " + email);
        }
        return result;
    }

    public void addPerson (String name, String email, int age) throws IOException {
        validate(name, email, age);
        repo.appendNewLine(name + "," + email);

    }

    private void validate(String name, String email, int age){
        if(name == null || name.isBlank() || name.length() < 3){
            throw new IllegalArgumentException("El nombre es inciorrecto");
        }
        String em = (email == null) ? "" : email.trim();
        if (em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("mail incorrecto");
        }
        if (age < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Solo se aceptan mayores de edad (18+)");
        }
    }

}
