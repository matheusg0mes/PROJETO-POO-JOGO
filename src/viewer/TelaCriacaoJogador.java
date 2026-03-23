package viewer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaCriacaoJogador  {

    public static void abrir(Stage stage)  {
        Label label = new Label("Tela de Criação do jogador");
        VBox vbox = new VBox(label);
        vbox.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(vbox,400,500));
        stage.show();
    }
}
