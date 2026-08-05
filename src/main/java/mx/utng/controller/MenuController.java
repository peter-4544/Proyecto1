package mx.utng.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MenuController {

    @FXML
    private AnchorPane panelContenido;

    @FXML
    private void abrirLibros() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/mx/utng/view/fx_canciones.fxml"));

            BorderPane vista = loader.load();

            panelContenido.getChildren().clear();

            panelContenido.getChildren().add(vista);

            AnchorPane.setTopAnchor(vista, 0.0);
            AnchorPane.setBottomAnchor(vista, 0.0);
            AnchorPane.setLeftAnchor(vista, 0.0);
            AnchorPane.setRightAnchor(vista, 0.0);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void abrirUsuarios() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/mx/utng/view/fx_usuarios.fxml"));

            AnchorPane vista = loader.load();

            panelContenido.getChildren().clear();

            panelContenido.getChildren().add(vista);

            AnchorPane.setTopAnchor(vista, 0.0);
            AnchorPane.setBottomAnchor(vista, 0.0);
            AnchorPane.setLeftAnchor(vista, 0.0);
            AnchorPane.setRightAnchor(vista, 0.0);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*@FXML
    private void abrirUsuarios() {

    }*/

    @FXML
    private void abrirPrestamos() {

    }

    @FXML
    private void abrirDevoluciones() {

    }

    @FXML
    private void abrirReportes() {

    }

    @FXML
    private void cerrarSesion() {

    }

}
