package viewer.telabatalha;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Cartas;
import model.Jogador;
import music.InstanciasMusicas;

public class TelaBatalha {

    static InstanciasMusicas musica = new InstanciasMusicas();

    public static void start(Stage stage, Jogador jogador1, Jogador jogador2) {
        InstanciasMusicas.tocarNaruto();

        Pane pane = new Pane();

        String estiloLabel = "-fx-text-fill: white; " +
                "-fx-font-size: 13px; " +
                "-fx-font-weight: bold; " +
                "-fx-background-color: rgba(0,0,0,0.55); " +
                "-fx-padding: 3 6 3 6; " +
                "-fx-background-radius: 4px;";

        String estiloLabelJ2 = "-fx-text-fill: white; " +
                "-fx-font-size: 13px; " +
                "-fx-font-weight: bold; " +
                "-fx-background-color: rgba(0,0,0,0.55); " +
                "-fx-padding: 3 6 3 6; " +
                "-fx-background-radius: 4px;";

        String estiloBotao = "-fx-background-color: rgba(0,0,0,0.7); " +
                "-fx-border-color: cyan; " +
                "-fx-border-width: 2px; " +
                "-fx-border-radius: 8px; " +
                "-fx-background-radius: 8px; " +
                "-fx-text-fill: cyan; " +
                "-fx-font-size: 14px; " +
                "-fx-font-weight: bold;";

        // --- Nomes dos jogadores ---
        Label nomeJ1 = new Label(jogador1.getNome());
        nomeJ1.setLayoutX(30);
        nomeJ1.setLayoutY(12);
        nomeJ1.setStyle("-fx-text-fill: cyan; -fx-font-size: 18px; -fx-font-weight: bold; " +
                "-fx-background-color: rgba(0,0,0,0.5); -fx-padding: 2 8 2 8; -fx-background-radius: 4px;");

        Label nomeJ2 = new Label(jogador2.getNome());
        nomeJ2.setLayoutX(520);
        nomeJ2.setLayoutY(12);
        nomeJ2.setStyle("-fx-text-fill: #ff4444; -fx-font-size: 18px; -fx-font-weight: bold; " +
                "-fx-background-color: rgba(0,0,0,0.5); -fx-padding: 2 8 2 8; -fx-background-radius: 4px;");

        // --- Atributos carta Jogador 1 ---
        Label lblVelJ1 = new Label("Velocidade: -");
        lblVelJ1.setLayoutX(25);
        lblVelJ1.setLayoutY(165);
        lblVelJ1.setStyle(estiloLabel);

        Label lblAltJ1 = new Label("Altura: -");
        lblAltJ1.setLayoutX(25);
        lblAltJ1.setLayoutY(193);
        lblAltJ1.setStyle(estiloLabel);

        Label lblCartasJ1 = new Label("Cartas restantes: " + jogador1.getBaralho().size());
        lblCartasJ1.setLayoutX(25);
        lblCartasJ1.setLayoutY(221);
        lblCartasJ1.setStyle(estiloLabel);

        // --- Atributos carta Jogador 2 ---
        Label lblVelJ2 = new Label("Velocidade: -");
        lblVelJ2.setLayoutX(530);
        lblVelJ2.setLayoutY(165);
        lblVelJ2.setStyle(estiloLabelJ2);

        Label lblAltJ2 = new Label("Altura: -");
        lblAltJ2.setLayoutX(530);
        lblAltJ2.setLayoutY(193);
        lblAltJ2.setStyle(estiloLabelJ2);

        Label lblCartasJ2 = new Label("Cartas restantes: " + jogador2.getBaralho().size());
        lblCartasJ2.setLayoutX(530);
        lblCartasJ2.setLayoutY(221);
        lblCartasJ2.setStyle(estiloLabelJ2);

        // --- VS ---
        Label lblVS = new Label("VS");
        lblVS.setLayoutX(318);
        lblVS.setLayoutY(140);
        lblVS.setStyle("-fx-text-fill: red; -fx-font-size: 26px; -fx-font-weight: bold; " +
                "-fx-background-color: rgba(0,0,0,0.5); -fx-padding: 2 8 2 8; -fx-background-radius: 4px;");

        // --- Resultado da rodada ---
        Label lblResultado = new Label("");
        lblResultado.setLayoutX(255);
        lblResultado.setLayoutY(250);
        lblResultado.setMaxWidth(310);
        lblResultado.setWrapText(true);
        lblResultado.setStyle("-fx-text-fill: yellow; -fx-font-size: 12px; -fx-font-weight: bold; " +
                "-fx-background-color: rgba(0,0,0,0.55); -fx-padding: 3 6 3 6; -fx-background-radius: 4px;");

        // --- Botão próxima rodada ---
        Button btnProxRodada = new Button("Próxima Rodada");
        btnProxRodada.setLayoutX(265);
        btnProxRodada.setLayoutY(328);
        btnProxRodada.setMinWidth(150);
        btnProxRodada.setMinHeight(35);
        btnProxRodada.setStyle(estiloBotao);

        pane.getChildren().addAll(
                nomeJ1, nomeJ2,
                lblVelJ1, lblAltJ1, lblCartasJ1,
                lblVelJ2, lblAltJ2, lblCartasJ2,
                lblResultado, lblVS, btnProxRodada
        );

        // --- Lógica do botão ---
        btnProxRodada.setOnAction(e -> {

            // Verifica se a batalha já acabou
            if (jogador1.getBaralho().isEmpty() || jogador2.getBaralho().isEmpty()) {
                return;
            }

            // Pega as cartas do topo
            Cartas cartaJ1 = jogador1.getBaralho().peek();
            Cartas cartaJ2 = jogador2.getBaralho().peek();

            // Exibe atributos
            lblVelJ1.setText("Velocidade: " + cartaJ1.getVelocidade());
            lblAltJ1.setText("Altura: " + cartaJ1.getAltura());
            lblVelJ2.setText("Velocidade: " + cartaJ2.getVelocidade());
            lblAltJ2.setText("Altura: " + cartaJ2.getAltura());

            // Pontuação da rodada
            int pontosJ1 = 0;
            int pontosJ2 = 0;

            // Compara velocidade
            if (cartaJ1.getVelocidade() > cartaJ2.getVelocidade()) pontosJ1++;
            else if (cartaJ2.getVelocidade() > cartaJ1.getVelocidade()) pontosJ2++;

            // Compara altura
            if (cartaJ1.getAltura() > cartaJ2.getAltura()) pontosJ1++;
            else if (cartaJ2.getAltura() > cartaJ1.getAltura()) pontosJ2++;

            // Aplica resultado
            if (pontosJ1 > pontosJ2) {
                jogador2.getBaralho().pop();
                lblResultado.setText(jogador1.getNome() + " venceu a rodada!");
            } else if (pontosJ2 > pontosJ1) {
                jogador1.getBaralho().pop();
                lblResultado.setText(jogador2.getNome() + " venceu a rodada!");
            } else {
                jogador1.getBaralho().pop();
                jogador2.getBaralho().pop();
                lblResultado.setText("Empate! As duas cartas foram removidas.");
            }

            // Atualiza cartas restantes
            lblCartasJ1.setText("Cartas restantes: " + jogador1.getBaralho().size());
            lblCartasJ2.setText("Cartas restantes: " + jogador2.getBaralho().size());

            // Verifica fim de jogo
            if (jogador1.getBaralho().isEmpty() && jogador2.getBaralho().isEmpty()) {
                lblResultado.setText("Empate geral! Sem vencedor.");
                btnProxRodada.setDisable(true);
                InstanciasMusicas.pararMusica();
                InstanciasMusicas.tocarNarutoBad();
            } else if (jogador1.getBaralho().isEmpty()) {
                lblResultado.setText(jogador2.getNome() + " VENCEU O JOGO!");
                btnProxRodada.setDisable(true);
                InstanciasMusicas.pararMusica();
                InstanciasMusicas.tocarNarutoBad();
            } else if (jogador2.getBaralho().isEmpty()) {
                lblResultado.setText(jogador1.getNome() + " VENCEU O JOGO!");
                btnProxRodada.setDisable(true);
                InstanciasMusicas.pararMusica();
                InstanciasMusicas.tocarNarutoBad();
            }
        });

        pane.setStyle("-fx-background-image: url('viewer/telabatalha/batalha.png');");
        stage.setScene(new Scene(pane, 700, 381));
        stage.setTitle("Batalha!");
        stage.show();
    }
}