package model;

public class Cartas {

    private Integer id;
    private Double velocidade;
    private Double altura;

    public Cartas(Integer id, Double velocidade, Double altura) {
        this.id = id;
        this.velocidade = velocidade;
        this.altura = altura;
    }

    public Integer getId() {
        return id;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public Double getAltura() {
        return altura;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }
}
