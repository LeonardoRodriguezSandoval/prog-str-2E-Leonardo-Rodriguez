package com.example.loginydashboard;

public class InputValidatorController {

    public static String validarUsuario(String usuario) {

        if (usuario == null || usuario.isEmpty()) {
            return "El usuario no puede estar vacío";
        }

        if (usuario.length() < 4) {
            return "El usuario debe tener mínimo 4 caracteres,porfavor vuelve a introducir el nombre del usuario";
        }

        return "";
    }

    public static String validarCorreo(String correo) {

        if (correo == null || correo.isEmpty()) {
            return "El correo no puede estar vacío";
        }

        if (!correo.contains("@") || !correo.contains(".")) {
            return "Correo inválido,el correo debe contener @ y un punto (ejemplo: corre@gmail.com)";
        }

        return "";
    }

    public static String validarPassword(String password) {

        if (password == null || password.isEmpty()) {
            return "La contraseña no puede estar vacía,porfavor vuelve a introducir la contraseña";
        }

        if (password.length() < 6) {
            return "La contraseña debe tener mínimo 6 caracteres";
        }

        return "";
    }
}
