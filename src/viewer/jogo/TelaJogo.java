package viewer.jogo;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Jogador;
import music.InstanciasMusicas;
import viewer.telabatalha.TelaBatalha;

import java.util.List;

public class TelaJogo {

    static InstanciasMusicas musica = new InstanciasMusicas();

    public static void start(Stage stage) {
        Pane pane = new Pane();

        String estiloBotao = "-fx-background-color: transparent; " +
                "-fx-border-color: transparent; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 18px; " +
                "-fx-font-family: 'Arial'; " +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white";

        String estinoBatalha = "-fx-background-color: #2E8B57;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-background-radius: 10px;" +
                "-fx-padding: 10 20 10 20;";

        ComboBox<String> cbJogadores1 = new ComboBox<>();
        cbJogadores1.getItems().addAll("Jogador-1", "Jogador-2", "Jogador-3");

        cbJogadores1.setLayoutX(50);
        cbJogadores1.setLayoutY(100);
        cbJogadores1.setStyle(estiloBotao);
        pane.getChildren().add(cbJogadores1);

        ImageView fotoJogador = new ImageView();
        fotoJogador.setLayoutX(40);
        fotoJogador.setLayoutY(150);
        fotoJogador.setFitWidth(150);
        fotoJogador.setFitHeight(180);
        pane.getChildren().add(fotoJogador);

        ComboBox<String> cbJogadores2 = new ComboBox<>();
        cbJogadores2.getItems().addAll("Jogador-1", "Jogador-2", "Jogador-3");

        cbJogadores2.setLayoutX(510);
        cbJogadores2.setLayoutY(100);
        cbJogadores2.setStyle(estiloBotao);
        pane.getChildren().add(cbJogadores2);

        ImageView fotoJogador2 = new ImageView();
        fotoJogador2.setLayoutX(510);
        fotoJogador2.setLayoutY(150);
        fotoJogador2.setFitWidth(150);
        fotoJogador2.setFitHeight(180);
        pane.getChildren().add(fotoJogador2);


        Button iniciarBtn = new Button("BATALHAR");
        iniciarBtn.setLayoutX(280);
        iniciarBtn.setLayoutY(300);
        iniciarBtn.setMinHeight(40);
        iniciarBtn.setMinWidth(150);
        iniciarBtn.setStyle(estinoBatalha);
        pane.getChildren().add(iniciarBtn);

        iniciarBtn.setOnAction(e -> {
            InstanciasMusicas.pararMusica();
            String nomeJ1 = cbJogadores1.getValue();
            String nomeJ2 = cbJogadores2.getValue();

            // Validações
            if (nomeJ1 == null || nomeJ2 == null) {
                System.out.println("Selecione os dois jogadores!");
                return;
            }
            if (nomeJ1.equals(nomeJ2)) {
                System.out.println("Selecione jogadores diferentes!");
                return;
            }

            // Busca os jogadores pelo nome
            List<Jogador> todos = MockisDados.getJogadores();

            Jogador jogador1 = todos.stream()
                    .filter(j -> j.getNome().equals(nomeJ1))
                    .findFirst()
                    .orElse(null);

            Jogador jogador2 = todos.stream()
                    .filter(j -> j.getNome().equals(nomeJ2))
                    .findFirst()
                    .orElse(null);

            if (jogador1 == null || jogador2 == null) {
                System.out.println("Jogador não encontrado!");
                return;
            }

            // Vai para a tela de batalha passando os dois jogadores
            TelaBatalha.start(stage, jogador1, jogador2);
        });

        cbJogadores1.setOnAction(e -> {
            InstanciasMusicas.tocarSelecionar();
                    String selecionado = cbJogadores1.getValue();
                    Image foto = new Image("viewer/jogo/" + selecionado + ".png");
                    fotoJogador.setImage(foto);

                }
        );

        cbJogadores2.setOnAction(e -> {
            InstanciasMusicas.tocarSelecionar();
                    String selecionado = cbJogadores2.getValue();
                    Image foto2 = new Image("viewer/jogo/" + selecionado + ".png");
                    fotoJogador2.setImage(foto2);
                }
        );
        pane.setStyle("-fx-background-image: url('viewer/jogo/selecao.png');" + "-fx-background-repeat: no-repeat; ");
        stage.setScene(new Scene(pane, 700, 360));
        stage.setTitle("Jogo de Cartas");
        stage.show();
    }
}
