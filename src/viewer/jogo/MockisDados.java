package viewer.jogo;

import model.Cartas;
import model.Jogador;

import java.util.List;
import java.util.Stack;

public class MockisDados {

    public static List<Jogador> getJogadores() {

        // Jogador 1
        Stack<Cartas> baralho1 = new Stack<>();
        baralho1.push(new Cartas(1, 120.0, 1.80));
        baralho1.push(new Cartas(2, 95.0,  1.75));
        baralho1.push(new Cartas(3, 110.0, 1.90));
        baralho1.push(new Cartas(4, 130.0, 1.70));
        baralho1.push(new Cartas(5, 88.0,  1.85));
        Jogador j1 = new Jogador(1, "Jogador-1", baralho1);

        // Jogador 2
        Stack<Cartas> baralho2 = new Stack<>();
        baralho2.push(new Cartas(6,  100.0, 1.78));
        baralho2.push(new Cartas(7,  115.0, 1.82));
        baralho2.push(new Cartas(8,  90.0,  1.88));
        baralho2.push(new Cartas(9,  125.0, 1.72));
        baralho2.push(new Cartas(10, 105.0, 1.95));
        Jogador j2 = new Jogador(2, "Jogador-2", baralho2);

        // Jogador 3
        Stack<Cartas> baralho3 = new Stack<>();
        baralho3.push(new Cartas(11, 118.0, 1.77));
        baralho3.push(new Cartas(12, 92.0,  1.83));
        baralho3.push(new Cartas(13, 108.0, 1.91));
        baralho3.push(new Cartas(14, 135.0, 1.68));
        baralho3.push(new Cartas(15, 98.0,  1.86));
        Jogador j3 = new Jogador(3, "Jogador-3", baralho3);

        return List.of(j1, j2, j3);
    }
}
