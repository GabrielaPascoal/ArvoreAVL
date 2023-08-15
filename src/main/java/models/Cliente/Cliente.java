package main.java.models.Cliente;

import main.java.models.ArvoreAVL.No;
import main.java.models.Veiculo;
import main.java.servidor.Servidor;

import java.util.List;

public class Cliente {
    private Servidor servidor;

    public Cliente(Servidor servidor){
        this.servidor = servidor;
    }

    public String inserir(Veiculo veiculo){
        servidor.inserir(veiculo);
        return "Veículo cadastrado :)";
    }

    public String editar(String renavam, Veiculo newVeiculo){
        return servidor.editar(renavam, newVeiculo);
    }

    public String remover(String renavam){
        return servidor.remover(renavam);
    }

    public String buscarTodos(){
        StringBuilder stringBuilder = new StringBuilder();
        List<No<Veiculo>> list = servidor.buscarTodos();

        if(list.isEmpty()){
            return "Nenhum veículo no sistema";
        }

        for(No<Veiculo> no : list){
            stringBuilder.append(no.getChave() + " - " +no.getValor().toString() + "\n");
        }

        return stringBuilder.toString();
    }

    public String buscar(String renavam, String placa){
        return servidor.buscar(renavam, placa);
    }

    public String totalVeiculos(){
        int total = servidor.total();
        return "Total de veículos no sistema: " + total;
    }

    public Boolean verificar(String renavam, String placa){
        return servidor.verificar(renavam, placa);
    }
}
