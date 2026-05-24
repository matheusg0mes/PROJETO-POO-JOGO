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

        Label velocidadeLB = new Label("");
        Label alturaLB = new Label("");

        Button btnBuscar = new Button("Buscar");
        btnBuscar.setOnAction(e -> resposta(velocidadeLB, alturaLB));
        btnBuscar.setTranslateY(100);
        btnBuscar.setTranslateX(100);

        Button btnVoltar = new Button("Voltar");
        btnVoltar.setOnAction(e -> MenuCartas.start(stage));
        btnVoltar.setTranslateY(75);
        btnVoltar.setTranslateX(200);

        VBox vbox = new VBox(10, idLb, id, btnBuscar, velocidadeLB, alturaLB, btnVoltar);

        stage.setScene(new Scene(vbox, 400, 500));
        stage.show();
    }

    private static void resposta(Label velocidadeLB, Label alturaLB) {
        try {
            Integer idVal = Integer.parseInt(id.getText().trim());

            CartasController controller = new CartasController();
            Cartas carta = controller.buscarPorId(idVal);

            velocidadeLB.setText("Velocidade: " + carta.getVelocidade());
            alturaLB.setText("Altura: " + carta.getAltura());

            System.out.println("Carta encontrada!");

        } catch (NumberFormatException ex) {
            System.out.println("Digite um id válido!");
        } catch (Exceptions ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}