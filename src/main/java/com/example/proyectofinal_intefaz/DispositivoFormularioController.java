package com.example.proyectofinal_intefaz;

import com.example.proyectofinal_intefaz.model.Dispositivo;
import com.example.proyectofinal_intefaz.model.TipoAtributo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

/**
 * Controlador para el formulario de dispositivos.
 */
public class DispositivoFormularioController {

    @FXML
    private TextField txtIdentificador;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private DatePicker datePickerFechaCompra;

    @FXML
    private TextField txtPrecio;

    @FXML
    private ComboBox<String> comboTipo;

    private InventarioController inventarioController;

    /**
     * Establece el controlador del inventario.
     *
     * @param inventarioController El controlador del inventario.
     */
    public void setInventarioController(InventarioController inventarioController) {
        this.inventarioController = inventarioController;
    }

    /**
     * Guarda un dispositivo con los datos del formulario.
     *
     * @param actionEvent El evento de acción.
     */
    @FXML
    public void guardarDispositivo(ActionEvent actionEvent) {
        // Obtener los valores de los campos del formulario
        String tipoSeleccionado = comboTipo.getSelectionModel().getSelectedItem();
        String identificador = txtIdentificador.getText();
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();
        String precioStr = txtPrecio.getText();
        double precio = Double.parseDouble(precioStr);
        LocalDate fechaCompraLocalDate = datePickerFechaCompra.getValue();

        // Crear un nuevo objeto Dispositivo con los datos del formulario
        Dispositivo dispositivo = new Dispositivo(identificador, fechaCompraLocalDate, precio, TipoAtributo.valueOf(tipoSeleccionado.toUpperCase()), marca, modelo);

        // Agregar el dispositivo al inventario a través del controlador del inventario
        inventarioController.agregarDispositivo(dispositivo);

        // Cerrar la ventana del formulario
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Rellena los campos del formulario con los datos del dispositivo seleccionado.
     *
     * @param dispositivo El dispositivo seleccionado.
     */
    public void CambiarDatosVentana(Dispositivo dispositivo) {
        // Establecer los valores de los campos del formulario con los datos del dispositivo
        txtIdentificador.setText(dispositivo.getIdentificador());
        comboTipo.setValue(dispositivo.getTipoAtributo().toString());
        txtMarca.setText(dispositivo.getMarca());
        txtModelo.setText(dispositivo.getModelo());
        txtPrecio.setText(String.valueOf(dispositivo.getPrecio()));
    }
}
