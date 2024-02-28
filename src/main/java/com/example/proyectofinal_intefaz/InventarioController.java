package com.example.proyectofinal_intefaz;

import com.example.proyectofinal_intefaz.model.Dispositivo;
import com.example.proyectofinal_intefaz.model.TipoAtributo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.ResourceBundle;


public class InventarioController implements Initializable {

    @FXML
    private ListView<Dispositivo> dispositivosListView;

    private DispositivoFormularioController dispositivoFormularioController;

    private ObservableList<Dispositivo> listaDeDispositivos;

    public void setDispositivoFormularioController(DispositivoFormularioController dispositivoFormularioController) {
        this.dispositivoFormularioController = dispositivoFormularioController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Crear una lista para almacenar dispositivos
        listaDeDispositivos = FXCollections.observableArrayList();

        LocalDate fecha = LocalDate.of(2020, 12, 20);
        LocalDate fecha2 = LocalDate.of(2014, 11, 8);
        LocalDate fecha3 = LocalDate.of(2017, 12, 10);
        // Crear y añadir dispositivos a la lista
        Dispositivo dispositivo1 = new Dispositivo("14741", fecha, 500.0, TipoAtributo.IMPRESORA, "Marca1", "Modelo1");
        Dispositivo dispositivo2 = new Dispositivo("142514", fecha2, 300.0, TipoAtributo.ORDENADOR, "Marca2", "Modelo2");
        Dispositivo dispositivo3 = new Dispositivo("87584", fecha3, 100.0, TipoAtributo.PORTATIL, "Marca3", "Modelo3");

        listaDeDispositivos.addAll(dispositivo1, dispositivo2, dispositivo3);

        dispositivosListView.setItems(listaDeDispositivos);

    }

    @FXML
    private void altaButtonClick() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DatosDispositivos.fxml"));
        try {
            Parent root = loader.load();
            DispositivoFormularioController controller = loader.getController();
            controller.setInventarioController(this); // Establecer el controlador principal
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); // Hacer que la ventana sea modal
            stage.showAndWait(); // Mostrar la ventana y esperar a que se cierre
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void agregarDispositivo(Dispositivo dispositivo) {
        dispositivosListView.getItems().add(dispositivo);
    }


    @FXML
    private void modificacionButtonClick() {

    }


    @FXML
    private void imprimirButtonClick() {

        String nombreArchivo = "datos_dispositivos.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {

            for (Dispositivo dispositivo : listaDeDispositivos) {
                writer.write(dispositivo.toString());
                writer.newLine();
            }
            System.out.println("Datos de dispositivos escritos en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void ordenarButtonClick() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Ordenar");

        // Crear botones para ordenar ascendente y descendente
        Button ascendenteButton = new Button("Ascendente");
        Button descendenteButton = new Button("Descendente");

        // Configurar acciones de los botones
        ascendenteButton.setOnAction(e -> ordenarAscendente());
        descendenteButton.setOnAction(e -> ordenarDescendente());

        // Layout de la ventana
        HBox layout = new HBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(ascendenteButton, descendenteButton);

        // Mostrar la ventana
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }


    private void ordenarAscendente() {
        // Ordenar la lista de dispositivos por fecha de forma ascendente
        listaDeDispositivos.sort(Comparator.comparing(Dispositivo::getFechaCompra));
    }

    private void ordenarDescendente() {
        // Ordenar la lista de dispositivos por fecha de forma descendente
        listaDeDispositivos.sort(Comparator.comparing(Dispositivo::getFechaCompra).reversed());

    }


}
