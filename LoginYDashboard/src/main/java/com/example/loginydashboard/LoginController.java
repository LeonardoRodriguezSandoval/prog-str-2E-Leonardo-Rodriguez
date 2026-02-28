package com.example.loginydashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblError;

    @FXML
    private void handleLogin(ActionEvent event) {

        String usuario = txtUsuario.getText();
        String correo = txtCorreo.getText();
        String password = txtPassword.getText();

        String error;

        error = com.example.loginydashboard.InputValidatorController.validarUsuario(usuario);
        if (!error.isEmpty()) {
            lblError.setText(error);
            return;
        }

        error = com.example.loginydashboard.InputValidatorController.validarCorreo(correo);
        if (!error.isEmpty()) {
            lblError.setText(error);
            return;
        }

        error = com.example.loginydashboard.InputValidatorController.validarPassword(password);
        if (!error.isEmpty()) {
            lblError.setText(error);
            return;
        }

        lblError.setText("");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
            Parent root = loader.load();

            DashboardController controller = loader.getController();
            controller.setUsuario(usuario);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
