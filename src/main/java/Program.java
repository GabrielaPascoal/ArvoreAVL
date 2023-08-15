package main.java;

import main.java.models.Cliente.Cliente;
import main.java.models.Condutor;
import main.java.models.Veiculo;
import main.java.protocolo.Protocolo;
import main.java.servidor.Servidor;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            Servidor servidor = new Servidor();
            Cliente cliente = new Cliente(servidor);
            Protocolo protocolo = new Protocolo(cliente);

            System.out.print("\nSISTEMA DE CADASTRO DE VEÍCULOS\n");
            introducao();
            System.out.print("OPÇÃO: ");
            int opcao = scanner.nextInt();

            while(opcao != 0){

                switch (opcao) {
                    case 1:
                        cadastrar(scanner, protocolo);
                        break;
                    case 2:
                        editar(scanner, protocolo);
                        break;
                    case 3:
                        remover(scanner,protocolo);
                        break;
                    case 4:
                        listarTodos(protocolo);
                        break;
                    case 5:
                        buscar(scanner,protocolo);
                        break;
                    case 6:
                        totalVeiculos(protocolo);
                        break;
                    default:
                        introducao();
                }
                introducao();
                System.out.print("OPÇÃO: ");
                opcao = scanner.nextInt();
            }
        } catch (Exception e){
            System.out.println("Bad Request!");
        }
    }

    static void introducao(){
        System.out.print("\nSELECIONE A OPÇÃO DESEJADA:");
        System.out.print("\n1 - CADASTRAR");
        System.out.print("\n2 - EDITAR");
        System.out.print("\n3 - REMOVER");
        System.out.print("\n4 - LISTAR");
        System.out.print("\n5 - BUSCAR");
        System.out.print("\n6 - TOTAL VEÍCULOS NO SISTEMA");
        System.out.print("\n0 - SAIR\n");
    }

    static void cadastrar(Scanner scanner, Protocolo protocolo){
        scanner.nextLine();
        System.out.println("\n-- Cadastrar --\n");
        System.out.print("Nome condutor: ");
        String nomeCondutor = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Renavam: ");
        String renavam = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Data fabricação: ");
        String dataFab = scanner.nextLine();

        Veiculo veiculo = new Veiculo();
        veiculo.setCondutor(new Condutor(nomeCondutor, cpf));
        veiculo.setPlaca(placa);
        veiculo.setRenavam(renavam);
        veiculo.setModelo(modelo);
        veiculo.setDataFab(dataFab);

        String resp = protocolo.inserir(veiculo);
        System.out.println("--> " + resp);
    }

    static void editar(Scanner scanner, Protocolo protocolo){
        scanner.nextLine();
        System.out.println("\n-- Editar --\n");
        System.out.print("RENAVAM do veículo a ser EDITADO: ");
        String renavamEdicao = scanner.nextLine();
        System.out.print("PLACA do veículo a ser EDITADO: ");
        String placaEdicao = scanner.nextLine();

        if(protocolo.verificarRenavam(renavamEdicao, placaEdicao)){
            System.out.println(protocolo.buscar(renavamEdicao, placaEdicao));
            System.out.print("Nome condutor: ");
            String nomeCondutor = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Placa: ");
            String placa = scanner.nextLine();
            System.out.print("Renavam: ");
            String renavam = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Data fabricação: ");
            String dataFab = scanner.nextLine();

            Veiculo veiculo = new Veiculo();
            veiculo.setCondutor(new Condutor(nomeCondutor, cpf));
            veiculo.setPlaca(placa);
            veiculo.setRenavam(renavam);
            veiculo.setModelo(modelo);
            veiculo.setDataFab(dataFab);

            String resp = protocolo.editar(renavamEdicao, veiculo);
            System.out.println(protocolo.buscar(renavamEdicao, placaEdicao));
            System.out.println("--> " + resp);
        }
        else {
            System.out.println("--> Veículo não encontrado. Confira os dados inseridos.");
        }
    }

    static void remover(Scanner scanner, Protocolo protocolo){
        scanner.nextLine();
        System.out.println("\n-- Remover --\n");
        System.out.print("RENAVAM do veículo a ser REMOVIDO: ");
        String renavamRemocao = scanner.nextLine();

        String resp = protocolo.remover(renavamRemocao);
        System.out.println("--> " + resp);
    }

    static void listarTodos(Protocolo protocolo){
        System.out.println("\n-- Listar Todos --\n");
        String resp = protocolo.buscarTodos();
        System.out.println(resp);
    }

    static void buscar(Scanner scanner, Protocolo protocolo){
        scanner.nextLine();
        System.out.println("\n-- Buscar Por Renavam e Placa --\n");
        System.out.print("RENAVAM do veículo a ser BUSCADO: ");
        String renavamBusca = scanner.nextLine();
        System.out.print("PLACA do veículo a ser BUSCADO: ");
        String placaBusca = scanner.nextLine();

        String resp = protocolo.buscar(renavamBusca, placaBusca);
        System.out.println("--> " + resp);
    }

    static void totalVeiculos(Protocolo protocolo){
        System.out.println("\n-- Total Veículos --\n");

        String resp = protocolo.totalVeiculos();
        System.out.println("--> " + resp);
    }
}