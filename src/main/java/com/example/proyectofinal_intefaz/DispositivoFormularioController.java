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

    import java.time.Instant;
    import java.time.LocalDate;
    import java.time.ZoneId;
    import java.util.Date;

    public class DispositivoFormularioController {

        @FXML
        private TextField txtIdentificador;

        @FXML
        private TextField txtTipo;

        @FXML
        private TextField txtMarca;

        @FXML
        private TextField txtModelo;

        @FXML
        private DatePicker datePickerFechaCompra;

        @FXML
        private TextField txtPrecio;
        private InventarioController inventarioController;

        @FXML
        private ComboBox<String> comboTipo;

        public void setInventarioController(InventarioController inventarioController) {
            this.inventarioController = inventarioController;
        }

        @FXML
        public void guardarDispositivo(ActionEvent actionEvent) {


            String tipoSeleccionado = comboTipo.getSelectionModel().getSelectedItem();
            String identificador = txtIdentificador.getText();
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            String precioStr = txtPrecio.getText();
            double precio;

            precio = Double.parseDouble(precioStr);
            LocalDate fechaCompraLocalDate = datePickerFechaCompra.getValue();


            Dispositivo dispositivo = new Dispositivo(identificador, fechaCompraLocalDate, precio, TipoAtributo.valueOf(tipoSeleccionado.toUpperCase()), marca, modelo);
            inventarioController.agregarDispositivo(dispositivo);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();

        }

        public void CambiarDatosVentana(Dispositivo dispositivo){

            txtIdentificador.setText(String.valueOf(dispositivo.getIdentificador()));
            comboTipo.setValue(dispositivo.getTipoAtributo().toString()); // Establecer el valor en el ComboBox
            txtMarca.setText(dispositivo.getMarca());
            txtModelo.setText(dispositivo.getModelo());
            txtPrecio.setText(String.valueOf(dispositivo.getPrecio()));


        }
    }
