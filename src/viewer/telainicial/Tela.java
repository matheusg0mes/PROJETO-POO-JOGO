package viewer.telainicial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import music.InstanciasMusicas;
import viewer.menucartas.MenuCartas;

public class Tela extends Application {

    InstanciasMusicas musica = new InstanciasMusicas();
    static Integer cont = 0;

    @Override
    public void start(Stage stage) {

        if(cont == 0) {
            musica.musicaMenu();
            cont++;
        }

        Pane pane = new Pane();

        //configuração Label
        Label label = new Label("Bem-vindo ao Jogo!");
        VBox boxLabel = new VBox(label);

        label.setFont(Font.font("Arial", 20));
        boxLabel.setLayoutX(170);
        boxLabel.setLayoutY(50);
        pane.getChildren().add(boxLabel);

        //configuração butao administração
        Button btnIniciar = new Button("Administração");
        VBox boxBtnIniciar = new VBox(btnIniciar);

        boxBtnIniciar.setLayoutX(120);
        boxBtnIniciar.setLayoutY(130);
        btnIniciar.setMinHeight(40);
        btnIniciar.setMinWidth(60);
        pane.getChildren().add(boxBtnIniciar);

        //configuração butao jogar
        Button btnJogar = new Button("Jogar");
        VBox boxBtnJogar = new VBox(btnJogar);

        boxBtnJogar.setLayoutX(300);
        boxBtnJogar.setLayoutY(130);
        btnJogar.setMinHeight(40);
        btnJogar.setMinWidth(60);
        pane.getChildren().add(boxBtnJogar);

        pane.setStyle("-fx-background-image: url('viewer/telainicial/menuInicial.jpeg');");
        //configuração evento de chamada de tela
        btnIniciar.setOnAction(e -> {
            musica.musicaClick();
            MenuCartas.start(stage);
        });
        stage.setScene(new Scene(pane, 500, 400));
        stage.setTitle("Jogo de Cartas");
        stage.show();
    }
}