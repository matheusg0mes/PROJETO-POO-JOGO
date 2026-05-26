package viewer.menucartas;

import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import music.InstanciasMusicas;
import viewer.telainicial.Tela;
import viewer.TelaAtualizarCartas;
import viewer.TelaBuscarCartas;
import viewer.TelaCriacaoCartas;
import viewer.TelaDeletarCartas;

public class MenuCartas {

    static InstanciasMusicas musica = new InstanciasMusicas();

    public static void start(Stage stage) {
        Pane pane = new Pane();
         String estiloBotao = "-fx-background-color: transparent; " +
                 "-fx-border-color: transparent; " +
                 "-fx-text-fill: white; " +
                 "-fx-font-size: 18px; " +
                 "-fx-font-family: 'Arial'; " +
                 "-fx-font-weight: bold;";

        // Botão Voltar — caixa 1 (topo)
        Button btnVoltar = new Button("Voltar");
        VBox boxVoltar = new VBox(btnVoltar);
        boxVoltar.setLayoutX(18);
        boxVoltar.setLayoutY(5);
        btnVoltar.setMinHeight(70);
        btnVoltar.setMinWidth(315);
        pane.getChildren().add(boxVoltar);

        // Botão Criar — caixa 2
        Button btnCriar = new Button("Criar");
        VBox boxCriar = new VBox(btnCriar);
        boxCriar.setLayoutX(18);
        boxCriar.setLayoutY(98);
        btnCriar.setMinHeight(85);
        btnCriar.setMinWidth(315);
        pane.getChildren().add(boxCriar);

        // Botão Buscar — caixa 3
        Button btnBuscar = new Button("Buscar");
        VBox boxBuscar = new VBox(btnBuscar);
        boxBuscar.setLayoutX(18);
        boxBuscar.setLayoutY(208);
        btnBuscar.setMinHeight(85);
        btnBuscar.setMinWidth(315);
        pane.getChildren().add(boxBuscar);

        // Botão Alterar — caixa 4
        Button btnAlterar = new Button("Alterar");
        VBox boxAlterar = new VBox(btnAlterar);
        boxAlterar.setLayoutX(18);
        boxAlterar.setLayoutY(308);
        btnAlterar.setMinHeight(85);
        btnAlterar.setMinWidth(315);
        pane.getChildren().add(boxAlterar);

        // Botão Excluir — caixa 5
        Button btnDeleta = new Button("Excluir");
        VBox boxDeleta = new VBox(btnDeleta);
        boxDeleta.setLayoutX(18);
        boxDeleta.setLayoutY(418);
        btnDeleta.setMinHeight(85);
        btnDeleta.setMinWidth(315);
        pane.getChildren().add(boxDeleta);

        //estilo dos butoes
        btnVoltar.setStyle(estiloBotao);
        btnCriar.setStyle(estiloBotao);
        btnBuscar.setStyle(estiloBotao);
        btnAlterar.setStyle(estiloBotao);
        btnDeleta.setStyle(estiloBotao);

        // Eventos
        btnVoltar.setOnAction(e -> new Tela().start(stage));
        btnCriar.setOnAction(e -> {
            TelaCriacaoCartas.abrir(stage);
            InstanciasMusicas.tocarClick();
        });
        btnBuscar.setOnAction(e -> {
            TelaBuscarCartas.abrir(stage);
            InstanciasMusicas.tocarClick();
        });
        btnAlterar.setOnAction(e -> {
            TelaAtualizarCartas.abrir(stage);
            InstanciasMusicas.tocarClick();
        });
        btnDeleta.setOnAction(e -> {
            TelaDeletarCartas.abrir(stage);
            InstanciasMusicas.tocarClick();
        });

        pane.setStyle("-fx-background-image: url('viewer/menucartas/menuCartas.png');");
        stage.setScene(new Scene(pane, 351, 541));
        stage.show();
    }
}