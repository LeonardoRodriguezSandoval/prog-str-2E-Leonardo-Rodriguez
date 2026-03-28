package com.example.practicaexamenu3.controllers;

import com.example.practicaexamenu3.Contacto;
import com.example.practicaexamenu3.service.ContactService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ContactController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<String> cbParentesco;
    @FXML
    private ListView<Contacto> listView;

    private ContactService service = new ContactService();

    private String[] parentescos = {
            "Padre", "Madre", "Hermano", "Hermana",
            "Abuelo", "Abuela", "Tío", "Tía"
    };

    @FXML
    public void initialize() {
        cbParentesco.getItems().addAll(parentescos);
    }

    @FXML
    public void agregar() {
        Contacto contacto = new Contacto(
                txtNombre.getText(),
                txtTelefono.getText(),
                cbParentesco.getValue()
        );

        String mensaje = service.agregar(contacto);

        if (mensaje != null) {
            mostrar(mensaje);
            return;
        }

        actualizarLista();
        limpiar();
    }

    @FXML
    public void buscar() {
        Contacto contacto = service.buscar(txtNombre.getText());

        if (contacto == null) {
            mostrar("No encontrado");
            return;
        }

        txtTelefono.setText(contacto.getTelefono());
        cbParentesco.setValue(contacto.getParentesco());
    }

    @FXML
    public void actualizar() {
        String mensaje = service.actualizar(
                txtNombre.getText(),
                txtTelefono.getText(),
                cbParentesco.getValue()
        );

        if (mensaje != null) {
            mostrar(mensaje);
            return;
        }

        actualizarLista();
    }

    @FXML
    public void eliminar() {
        String mensaje = service.eliminar(txtNombre.getText());

        if (mensaje != null) {
            mostrar(mensaje);
            return;
        }

        actualizarLista();
        limpiar();
    }

    @FXML
    public void limpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.setValue(null);
    }

    private void actualizarLista() {
        listView.getItems().clear();
        listView.getItems().addAll(service.listar());
    }

    private void mostrar(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.show();
    }
}
