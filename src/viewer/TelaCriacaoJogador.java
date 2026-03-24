package viewer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaCriacaoJogador  {

    public static void abrir(Stage stage)  {
        Label idLb = new Label("Digite o id do jogador");

        idLb.setTranslateY(10);

        TextField id = new TextField();
        id.setPromptText("Digite o id");

        id.setTranslateY(20);
        id.setMaxWidth(200);
        id.setMaxHeight(30);

        Label nomeLb = new Label("Digite o nome do jogador");

        nomeLb.setTranslateY(30);

        TextField nome = new TextField();
        nome.setPromptText("Digite o nome");

        nome.setTranslateY(30);
        nome.setMaxWidth(200);
        nome.setMaxHeight(30);

        Label deckLb = new Label("Digite o id do deck");

        deckLb.setTranslateY(30);

        TextField deck = new TextField();
        deck.setPromptText("Digite id do deck");

        deck.setTranslateY(30);
        deck.setMaxWidth(200);
        deck.setMaxHeight(30);

        Button btnCriar = new Button("Criar Jogador");

        btnCriar.setOnAction(e -> resposta());

        btnCriar.setTranslateY(100);
        btnCriar.setTranslateX(100);

        VBox vbox = new VBox(idLb,id,nomeLb,nome,deckLb,deck,btnCriar);

        stage.setScene(new Scene(vbox,400,500));
        stage.show();
    }

    public static void resposta(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Jogador criado com sucesso");
        alert.show();
    }
}
