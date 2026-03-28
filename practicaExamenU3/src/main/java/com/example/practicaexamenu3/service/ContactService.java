package com.example.practicaexamenu3.service;

import com.example.practicaexamenu3.Contacto;
import com.example.practicaexamenu3.repository.ContactRepository;
import java.util.ArrayList;

public class ContactService {

    private ContactRepository repo = new ContactRepository();

    public String agregar(Contacto contacto) {

        if (contacto.getNombre().isEmpty()){
            return "Nombre vacío";
        }
        if (contacto.getTelefono().isEmpty()){
            return "Teléfono vacío";
        }
        if (contacto.getTelefono().length() != 10){
            return "Teléfono inválido";
        }
        if (contacto.getParentesco() == null){
            return "Selecciona parentesco";
        }

        if (repo.buscarPorNombre(contacto.getNombre()) != null) {
            return "Ya existe ese contacto";
        }

        repo.guardar(contacto);
        return null;
    }

    public Contacto buscar(String nombre) {
        return repo.buscarPorNombre(nombre);
    }

    public ArrayList<Contacto> listar() {
        return repo.obtenerTodos();
    }

    public String actualizar(String nombre, String telefono, String parentesco) {

        Contacto contacto = repo.buscarPorNombre(nombre);

        if (contacto == null) return "No encontrado";

        contacto.setTelefono(telefono);
        contacto.setParentesco(parentesco);

        return null;
    }

    public String eliminar(String nombre) {
        Contacto contacto = repo.buscarPorNombre(nombre);

        if (contacto == null) return "No encontrado";

        repo.eliminar(contacto);
        return null;
    }
}
