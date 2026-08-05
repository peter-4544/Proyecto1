package mx.utng.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import mx.utng.dao.CancionDAO;
import mx.utng.model.Cancion;


public class CancionController {
    
    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtInterprete;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtAnio;

    @FXML
    private TextField txtBuscar;

    //tabView
    @FXML
    private TableView<Cancion> tblCanciones;

    @FXML
    private TableColumn<Cancion,Integer> colId;

    @FXML
    private TableColumn<Cancion,String> colTitulo;

    @FXML
    private TableColumn<Cancion,String> colInterprete;

    @FXML
    private TableColumn<Cancion,String> colGenero;

    @FXML
    private TableColumn<Cancion,Integer> colAnio;


    private CancionDAO dao = new CancionDAO();




    @FXML
    private void nuevo() {

        txtTitulo.clear();
        txtInterprete.clear();
        txtGenero.clear();
        txtAnio.clear();

    }

    @FXML
    public void initialize() {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colInterprete.setCellValueFactory(new PropertyValueFactory<>("interprete"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));

        cargarCanciones();
    }

    private void cargarCanciones(){

        ObservableList<Cancion> lista =
                FXCollections.observableArrayList(
                        dao.listar()
                );

        // aquí conectaremos el TableView
                tblCanciones.setItems(lista);      //<---
    }





    @FXML
    private void guardarCancion(){

        Cancion cancion = new Cancion();

        cancion.setTitulo(txtTitulo.getText());
        cancion.setInterprete(txtInterprete.getText());
        cancion.setGenero(txtGenero.getText());

        cancion.setAnio(
            Integer.parseInt(txtAnio.getText())
        );


        if(dao.guardar(cancion)){

            mostrarMensaje("Cancion guardada correctamente");
            limpiar();
            cargarCanciones();

        }

        //<---
        mostrarTabla();
    }


    @FXML
    private void actualizar(){
        System.out.println("Actualizando...");
        Cancion cancion = new Cancion();

        cancion.setTitulo(txtTitulo.getText());
        cancion.setInterprete(txtInterprete.getText());
        cancion.setGenero(txtGenero.getText());
        cancion.setAnio(Integer.parseInt(txtAnio.getText()));
        cancion.setId(Integer.parseInt(txtBuscar.getText()));

        if(dao.actualizar(cancion)){
            mostrarMensaje("Cancion Actualizada Correctamente!");
            limpiar();
            cargarCanciones();
        }else{
            mostrarMensaje("Error al Actualizar la cancion!");
        }
    }

    @FXML
    private void eliminar(){
        System.out.println("Eliminando...");
        int id= Integer.parseInt(txtBuscar.getText());
        if(dao.eliminar(id)){
            mostrarMensaje("Cancion Eliminada!!");
            limpiar();
            cargarCanciones();
        }else{
            mostrarMensaje("Cancion no encontrada!!");
        }
    }

    @FXML
    private void limpiar(){

        txtTitulo.clear();
        txtInterprete.clear();
        txtGenero.clear();
        txtAnio.clear();

    }

    @FXML
    private void buscar(){
        System.out.println("Buscando...");
        Cancion cancion = new Cancion();

        cancion = dao.buscar(Integer.parseInt(txtBuscar.getText()));

        if(cancion!=null){
            txtTitulo.setText(cancion.getTitulo());
            txtInterprete.setText(cancion.getInterprete());
            txtGenero.setText(cancion.getGenero());
            txtAnio.setText("" + cancion.getAnio());
        }else{
            mostrarMensaje("Cancion No encontrada!!");
        }
    }


    private void mostrarMensaje(String mensaje){

        Alert alerta =
                new Alert(Alert.AlertType.INFORMATION);

        alerta.setContentText(mensaje);
        alerta.show();

    }

    public void mostrarTabla() {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colInterprete.setCellValueFactory(new PropertyValueFactory<>("interprete"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));

        cargarCanciones();
    }
}