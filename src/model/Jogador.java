package model;

import java.util.Stack;

public class Jogador {

    private Integer id;
    private String nome;

    private Stack<Cartas> cartas;

    public Jogador(Integer id, String nome, Stack<Cartas> baralho) {
        this.id = id;
        this.nome = nome;
        this.cartas = baralho;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Stack<Cartas> getBaralho() {
        return cartas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setBaralho(Stack<Cartas> cartas) {
        this.cartas = cartas;
    }
}
