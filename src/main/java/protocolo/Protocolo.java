package main.java.protocolo;

import main.java.models.Cliente.Cliente;
import main.java.models.Veiculo;

public class Protocolo {

    private Cliente cliente;

    public Protocolo(Cliente cliente){
        this.cliente = cliente;
    }

    public String inserir(Veiculo veiculo){
        return cliente.inserir(veiculo);
    }

    public String editar(String renavam, Veiculo newVeiculo){
        return cliente.editar(renavam, newVeiculo);
    }

    public String remover(String renavam){
        return cliente.remover(renavam);
    }

    public String buscarTodos(){
        return cliente.buscarTodos();
    }

    public String buscar(String renavam, String placa){
        return cliente.buscar(renavam, placa);
    }

    public String totalVeiculos(){
        return cliente.totalVeiculos();
    }

    public Boolean verificarRenavam(String renavam, String placa){
        return cliente.verificar(renavam, placa);
    }
}