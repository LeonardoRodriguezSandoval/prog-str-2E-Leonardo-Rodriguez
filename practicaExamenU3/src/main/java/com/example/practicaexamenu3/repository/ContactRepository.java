package com.example.practicaexamenu3.repository;

import com.example.practicaexamenu3.Contacto;
import java.util.ArrayList;

public class ContactRepository {

    private ArrayList<Contacto> lista = new ArrayList<>();

    public void guardar(Contacto contacto) {
        lista.add(contacto);
    }

    public ArrayList<Contacto> obtenerTodos() {
        return lista;
    }

    public Contacto buscarPorNombre(String nombre) {
        for (Contacto contacto : lista) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public void eliminar(Contacto contacto) {
        lista.remove(contacto);
    }
}
