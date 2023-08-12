package main.java.entities;

public class Conductor {
    
    private String name;
    private String cpf;

    public Conductor(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }
}
