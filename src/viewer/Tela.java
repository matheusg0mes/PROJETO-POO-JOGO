package viewer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tela extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Label label = new Label("Bem-vindo ao Jogo!");
        Button btnIniciar = new Button("Iniciar Jogo");

        label.setTranslateY(10); // margem do topo

        VBox root = new VBox(label);
        root.setAlignment(javafx.geometry.Pos.TOP_CENTER);

        VBox center = new VBox(btnIniciar);
        center.setAlignment(javafx.geometry.Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(root);
        borderPane.setCenter(center);

        btnIniciar.setOnAction(e -> TelaCriacaoJogador.abrir(stage));
        stage.setScene(new Scene(borderPane, 400, 300));
        stage.setTitle("Jogo de Cartas");
        stage.show();
    }
}
