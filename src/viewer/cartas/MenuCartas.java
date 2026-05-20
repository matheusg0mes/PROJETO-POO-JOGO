package viewer.cartas;

import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class MenuCartas {

    public static void start(Stage stage)  {
        Pane pane = new Pane();

        Button btnCriar = new Button("Criar");
        VBox boxCriar = new VBox(btnCriar);

        boxCriar.setLayoutX(50);
        boxCriar.setLayoutY(50);
        btnCriar.setMinHeight(30);
        btnCriar.setMinWidth(60);
        pane.getChildren().add(boxCriar);

        Button btnBuscar = new Button("Buscar");
        VBox boxBuscar = new VBox(btnBuscar);

        boxBuscar.setLayoutX(150);
        boxBuscar.setLayoutY(50);
        btnBuscar.setMinHeight(30);
        btnBuscar.setMinWidth(60);
        pane.getChildren().add(boxBuscar);

        Button btnAlterar = new Button("Alterar");
        VBox boxAlterar = new VBox(btnAlterar);

        boxAlterar.setLayoutX(50);
        boxAlterar.setLayoutY(100);
        btnAlterar.setMinHeight(30);
        btnAlterar.setMinWidth(60);
        pane.getChildren().add(boxAlterar);

        Button btnDeleta = new Button("Excluir");
        VBox boxDeleta = new VBox(btnDeleta);

        boxDeleta.setLayoutX(150);
        boxDeleta.setLayoutY(100);
        btnDeleta.setMinHeight(30);
        btnDeleta.setMinWidth(60);
        pane.getChildren().add(boxDeleta);

        btnCriar.setOnAction(e -> TelaCriacaoCartas.abrir(stage));
        btnBuscar.setOnAction(e -> TelaBuscarCartas.abrir(stage));
        btnAlterar.setOnAction(e -> TelaAtualizarCartas.abrir(stage));
        btnDeleta.setOnAction(e -> TelaDeletarCartas.abrir(stage));
        stage.setScene(new Scene(pane,300,250));
        stage.show();
    }
}
