package main.java.entities;

public class Veiculo {
    private Condutor condutor;
    private String placa;
    private String renavam;
    private String modelo;
    private String DataFab;

    public Veiculo(String placa, String renavam, Condutor condutor, String modelo, String DataFab) {
        this.placa = placa;
        this.renavam = renavam;
        this.condutor = condutor;
        this.modelo = modelo;
        this.DataFab = DataFab;
    }
}
