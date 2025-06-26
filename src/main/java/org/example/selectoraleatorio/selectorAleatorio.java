package org.example.selectoraleatorio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.*;

public class selectorAleatorio extends Application {

    private final ArrayList<String> lista = new ArrayList<>();
    private final Random rd = new Random();

    @Override
    public void start(Stage stage) {
        TextField inputDato = new TextField();
        inputDato.setPromptText("Escribe un dato y presiona ENTER");

        Button btnAgregar = new Button("AGREGAR");
        TextArea areaLista = new TextArea();
        areaLista.setEditable(false);
        areaLista.setPrefRowCount(6);

        TextField inputCantidad = new TextField();
        inputCantidad.setPromptText("¿Cuántos quieres escoger?");

        Button btnSeleccionar = new Button("SELECCIONAR");
        TextArea areaResultado = new TextArea();
        areaResultado.setEditable(false);
        areaResultado.setPrefRowCount(6);

        VBox layout = new VBox(12, inputDato, btnAgregar, areaLista, inputCantidad, btnSeleccionar, areaResultado);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #000000;");

        String estiloVerdeNeon = """
            -fx-control-inner-background: #000000;
            -fx-background-color: #000000;
            -fx-text-fill: #00FF00;
            -fx-prompt-text-fill: #00FF00;
            -fx-border-color: #00FF00;
            -fx-border-width: 1px;
            -fx-border-radius: 8px;
            -fx-background-radius: 8px;
            -fx-font-family: 'Consolas';
            -fx-font-size: 14px;
        """;

        DropShadow glow = new DropShadow();
        glow.setColor(Color.web("#00FF00"));
        glow.setOffsetX(0);
        glow.setOffsetY(0);
        glow.setRadius(15);

        inputDato.setStyle(estiloVerdeNeon);
        btnAgregar.setStyle(estiloVerdeNeon + "-fx-cursor: hand;");
        areaLista.setStyle(estiloVerdeNeon);
        inputCantidad.setStyle(estiloVerdeNeon);
        btnSeleccionar.setStyle(estiloVerdeNeon + "-fx-cursor: hand;");
        areaResultado.setStyle(estiloVerdeNeon);

        btnAgregar.setEffect(glow);
        btnSeleccionar.setEffect(glow);

        inputDato.setOnAction(e -> btnAgregar.fire());

        btnAgregar.setOnAction(e -> {
            String dato = inputDato.getText().trim();
            if (!dato.isEmpty()) {
                if (!lista.contains(dato)) {
                    lista.add(dato);
                    inputDato.clear();
                    areaLista.setText(String.join("\n", lista));
                } else {
                    showAlert("Duplicado", "Este dato ya está en la lista.");
                }
            }
        });

        btnSeleccionar.setOnAction(e -> {
            areaResultado.clear();
            try {
                int cantidad = Integer.parseInt(inputCantidad.getText().trim());
                if (cantidad > lista.size()) {
                    showAlert("Error", "No hay suficientes elementos.");
                    return;
                }
                List<String> copia = new ArrayList<>(lista);
                Collections.shuffle(copia);
                for (int i = 0; i < cantidad; i++) {
                    areaResultado.appendText(copia.get(i) + "\n");
                }
            } catch (NumberFormatException ex) {
                showAlert("Error", "Introduce un número válido.");
            }
        });

        Scene scene = new Scene(layout, 500, 600);
        stage.setTitle("Selector Aleatorio Hacker Style");
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}