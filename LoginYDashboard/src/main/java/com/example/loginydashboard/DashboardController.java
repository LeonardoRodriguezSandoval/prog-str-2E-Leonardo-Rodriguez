package com.example.loginydashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label lblBienvenido;

    public void setUsuario(String usuario) {
        lblBienvenido.setText("Bienvenido, " + usuario);
    }
}
