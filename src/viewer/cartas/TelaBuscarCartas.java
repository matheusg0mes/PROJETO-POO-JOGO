package viewer.cartas;

import controller.CartasController;
import exceptions.Exceptions;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Cartas;

public class TelaBuscarCartas {

    private static TextField id;


    public static void abrir(Stage stage) {
        Label idLb = new Label("Digite o id da carta");
        idLb.setTranslateY(10);

        id = new TextField();
        id.setPromptText("Digite o id");
        id.setTranslateY(20);
        id.setMaxWidth(200);
        id.setMaxHeight(30);


        Button btnCriar = new Button("Buscar");
        btnCriar.setTranslateY(100);
        btnCriar.setTranslateX(100);

        Button btnVoltar = new Button("Voltar");
        btnVoltar.setOnAction(e -> MenuCartas.start(stage));
        btnVoltar.setTranslateY(75);
        btnVoltar.setTranslateX(200);

        VBox vbox = new VBox(idLb, id, btnCriar, btnVoltar);

        stage.setScene(new Scene(vbox, 400, 500));
        stage.show();
    }
}

