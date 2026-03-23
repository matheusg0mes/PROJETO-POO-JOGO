package model;

public class Rodada {

    private final static Integer NUMERO_RODADAS = 5;

    private Integer id;
    private Jogador p1;
    private Jogador p2;
    private Integer Rodadas = NUMERO_RODADAS;

    public Rodada(Integer id, Jogador p1, Jogador p2) {
        this.id = id;
        this.p1 = p1;
        this.p2 = p2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Jogador getP1() {
        return p1;
    }

    public void setP1(Jogador p1) {
        this.p1 = p1;
    }

    public Jogador getP2() {
        return p2;
    }

    public void setP2(Jogador p2) {
        this.p2 = p2;
    }
}
