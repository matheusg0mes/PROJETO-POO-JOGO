package viewer;

import controller.CartasController;
import exceptions.Exceptions;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Cartas;

public class TelaCriacaoJogador {

    private static TextField id;
    private static TextField velocidade;
    private static TextField altura;

    public static void abrir(Stage stage) {
        Label idLb = new Label("Digite o id da carta");
        idLb.setTranslateY(10);

        id = new TextField();
        id.setPromptText("Digite o id");
        id.setTranslateY(20);
        id.setMaxWidth(200);
        id.setMaxHeight(30);

        Label velocidadeLB = new Label("Digite a velocidade");
        velocidadeLB.setTranslateY(30);

        velocidade = new TextField();
        velocidade.setPromptText("Digite a velocidade");
        velocidade.setTranslateY(30);
        velocidade.setMaxWidth(200);
        velocidade.setMaxHeight(30);

        Label alturaLB = new Label("Digite a altura");
        alturaLB.setTranslateY(30);

        altura = new TextField();
        altura.setPromptText("Digite a altura");
        altura.setTranslateY(30);
        altura.setMaxWidth(200);
        altura.setMaxHeight(30);

        Button btnCriar = new Button("Criar Carta");
        btnCriar.setOnAction(e -> resposta());
        btnCriar.setTranslateY(100);
        btnCriar.setTranslateX(100);

        VBox vbox = new VBox(idLb, id, velocidadeLB, velocidade, alturaLB, altura, btnCriar);

        stage.setScene(new Scene(vbox, 400, 500));
        stage.show();
    }

    private static void resposta() {
        try {
            Integer idVal         = Integer.parseInt(id.getText().trim());
            Double velocidadeVal = Double.parseDouble(velocidade.getText().trim());
            Double alturaVal     = Double.parseDouble(altura.getText().trim());

            Cartas carta = new Cartas(idVal, velocidadeVal, alturaVal);

            CartasController controller = new CartasController();
           Cartas criado = controller.cadastrarCartas(carta);

            System.out.println("Carta criada com sucesso!");

        } catch (NumberFormatException ex) {
            System.out.println("Preencha todos os campos com números válidos!");
        } catch (Exceptions ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}