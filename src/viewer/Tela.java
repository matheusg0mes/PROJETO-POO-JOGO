package viewer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import viewer.cartas.MenuCartas;
import viewer.cartas.TelaCriacaoCartas;

public class Tela extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();

        //configuração Label
        Label label = new Label("Bem-vindo ao Jogo!");
        VBox boxLabel = new VBox(label);

        label.setFont(Font.font("Arial",20));
        boxLabel.setLayoutX(200);
        boxLabel.setLayoutY(50);
        pane.getChildren().add(boxLabel);

        //configuração butao
        Button btnIniciar = new Button("Cartas");
        VBox boxBtnIniciar = new VBox(btnIniciar);

        boxBtnIniciar.setLayoutX(120);
        boxBtnIniciar.setLayoutY(130);
        btnIniciar.setMinHeight(40);
        btnIniciar.setMinWidth(60);
        pane.getChildren().add(boxBtnIniciar);

        //configuração evento de chamada de tela
        btnIniciar.setOnAction(e -> MenuCartas.start(stage));
        stage.setScene(new Scene(pane, 600, 600));
        stage.setTitle("Jogo de Cartas");
        stage.show();
    }
}
