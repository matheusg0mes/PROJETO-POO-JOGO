package model;

public class Cartas {

    private Integer id;
    private Integer velocidade;
    private Integer altura;

    public Cartas(Integer id, Integer velocidade, Integer altura) {
        this.id = id;
        this.velocidade = velocidade;
        this.altura = altura;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }
}
