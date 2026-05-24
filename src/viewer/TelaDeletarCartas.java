package viewer;

import controller.CartasController;
import exceptions.Exceptions;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import viewer.menucartas.MenuCartas;

public class TelaDeletarCartas {

    private static TextField id;

    public static void abrir(Stage stage) {
        Label idLb = new Label("Digite o id da carta");
        idLb.setTranslateY(10);

        id = new TextField();
        id.setPromptText("Digite o id");
        id.setTranslateY(20);
        id.setMaxWidth(200);
        id.setMaxHeight(30);

        Button btnExcluir = new Button("Excluir");
        btnExcluir.setOnAction(e -> resposta());
        btnExcluir.setTranslateY(100);
        btnExcluir.setTranslateX(100);

        Button btnVoltar = new Button("Voltar");
        btnVoltar.setOnAction(e -> MenuCartas.start(stage));
        btnVoltar.setTranslateY(75);
        btnVoltar.setTranslateX(200);

        VBox vbox = new VBox(idLb, id, btnExcluir, btnVoltar);

        stage.setScene(new Scene(vbox, 400, 500));
        stage.show();
    }

    private static void resposta() {
        try {
            Integer idVal = Integer.parseInt(id.getText().trim());

            CartasController controller = new CartasController();
            controller.deleteCartas(idVal);

            System.out.println("Carta deletada com sucesso!");

        } catch (NumberFormatException ex) {
            System.out.println("Preencha o campo com um número válido!");
        } catch (Exceptions ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}