package model;

import java.util.ArrayList;
import java.util.List;

public class Baralho {

    private Integer id;
    private String nome;

    private List<Cartas> cartas = new ArrayList<Cartas>();

    public Baralho() {
    }

    public Baralho(Integer id, String nome, List<Cartas> cartas) {
        this.id = id;
        this.nome = nome;
        this.cartas = cartas;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Cartas> getCartas() {
        return cartas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCartas(List<Cartas> cartas) {
        this.cartas = cartas;
    }
}
