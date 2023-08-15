package main.java.models;

public class Veiculo {
    private Condutor condutor;
    private String placa;
    private String dataFab;
    private String renavam;
    private String modelo;

    public Veiculo(){}

    public Veiculo(Condutor condutor, String placa, String dataFab, String renavam, String modelo) {
        this.condutor = condutor;
        this.placa = placa;
        this.dataFab = dataFab;
        this.renavam = renavam;
        this.modelo = modelo;
    }



    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDataFab() {
        return dataFab;
    }

    public void setDataFab(String dataFab) {
        this.dataFab = dataFab;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "condutor=" + condutor +
                ", placa='" + placa + '\'' +
                ", dataFab='" + dataFab + '\'' +
                ", renavam='" + renavam + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
