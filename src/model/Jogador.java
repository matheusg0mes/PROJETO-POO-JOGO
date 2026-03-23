package model;

public class Jogador {

    private Integer id;
    private String nome;

    private Baralho baralho;

    public Jogador(Integer id, String nome, Baralho baralho) {
        this.id = id;
        this.nome = nome;
        this.baralho = baralho;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }
}
