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
import viewer.menucartas.MenuCartas;

public class TelaAtualizarCartas {

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

        Label velocidadeLB = new Label("Velocidade");
        velocidadeLB.setTranslateY(30);

        velocidade = new TextField();
        velocidade.setPromptText("Digite a velocidade");
        velocidade.setTranslateY(30);
        velocidade.setMaxWidth(200);
        velocidade.setMaxHeight(30);

        Label alturaLB = new Label("Altura");
        alturaLB.setTranslateY(30);

        altura = new TextField();
        altura.setPromptText("Digite a altura");
        altura.setTranslateY(30);
        altura.setMaxWidth(200);
        altura.setMaxHeight(30);

        Button btnBuscar = new Button("Buscar");
        btnBuscar.setOnAction(e -> buscar());
        btnBuscar.setTranslateY(60);
        btnBuscar.setTranslateX(100);

        Button btnAtualizar = new Button("Atualizar");
        btnAtualizar.setOnAction(e -> atualizar());
        btnAtualizar.setTranslateY(100);
        btnAtualizar.setTranslateX(100);

        Button btnVoltar = new Button("Voltar");
        btnVoltar.setOnAction(e -> MenuCartas.start(stage));
        btnVoltar.setTranslateY(75);
        btnVoltar.setTranslateX(200);

        VBox vbox = new VBox(10, idLb, id, btnBuscar, velocidadeLB, velocidade, alturaLB, altura, btnAtualizar, btnVoltar);
        stage.setScene(new Scene(vbox, 400, 500));
        stage.show();
    }

    private static void buscar() {
        try {
            Integer idVal = Integer.parseInt(id.getText().trim());

            CartasController controller = new CartasController();
            Cartas carta = controller.buscarPorId(idVal);

            velocidade.setText(String.valueOf(carta.getVelocidade()));
            altura.setText(String.valueOf(carta.getAltura()));

            System.out.println("Carta encontrada!");

        } catch (NumberFormatException ex) {
            System.out.println("Digite um id válido!");
        } catch (Exceptions ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    private static void atualizar() {
        try {
            Integer idVal        = Integer.parseInt(id.getText().trim());
            Double velocidadeVal = Double.parseDouble(velocidade.getText().trim());
            Double alturaVal     = Double.parseDouble(altura.getText().trim());

            Cartas carta = new Cartas(idVal, velocidadeVal, alturaVal);

            CartasController controller = new CartasController();
            controller.atualizar(carta);

            System.out.println("Carta atualizada com sucesso!");

        } catch (NumberFormatException ex) {
            System.out.println("Preencha todos os campos com números válidos!");
        } catch (Exceptions ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}