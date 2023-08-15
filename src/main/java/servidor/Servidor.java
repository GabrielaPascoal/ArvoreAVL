package main.java.servidor;

import main.java.models.ArvoreAVL.ArvoreAVL;
import main.java.models.ArvoreAVL.No;
import main.java.models.Condutor;
import main.java.models.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class Servidor {

    private ArvoreAVL<Veiculo> arvoreAVL;
    private int chave;

    public Servidor(){
        this.arvoreAVL = new ArvoreAVL<Veiculo>();
        chave = 0;
        inserirCinquentaVeiculos();
    }

    public void inserir(Veiculo veiculo){
        ++chave;
        arvoreAVL.inserir(chave, veiculo);
    }

    public String editar(String renavam, Veiculo newVeiculo){
        List<No<Veiculo>> veiculos = buscarTodos();
        var obj = veiculos.stream().filter(u -> u.getValor().getRenavam().equals(renavam)).findFirst();
        if(obj.isEmpty()){
            return "Veículo não encontrado. Confira os dados inseridos.";
        }
        Veiculo veiculoExistente = obj.get().getValor();
        veiculoExistente.setCondutor(newVeiculo.getCondutor());
        veiculoExistente.setModelo(newVeiculo.getModelo());
        veiculoExistente.setDataFab(newVeiculo.getDataFab());
        veiculoExistente.setRenavam(newVeiculo.getRenavam());
        veiculoExistente.setPlaca(newVeiculo.getPlaca());
        return "Edição feita.";
    }

    public String remover(String renavam){
        List<No<Veiculo>> veiculos = buscarTodos();
        var no = veiculos.stream().filter(u -> u.getValor().getRenavam().equals(renavam)).findFirst();
        if(no.isEmpty()){
            return "Veículo não encontrado. Confira os dados inseridos.";
        }

        arvoreAVL.remover(no.get().getChave());
        return "Veículo removido.";
    }

    public List<No<Veiculo>> buscarTodos(){
        List<No<Veiculo>> list = new ArrayList<>();
        for(int i = 1; i <= chave; i++){
            var obj = arvoreAVL.buscar(i);
            if(obj != null){
                list.add(obj);
            }
        }
        return list;
    }

    public String buscar(String renavam, String placa){
        List<No<Veiculo>> veiculos = buscarTodos();
        var no = veiculos.stream().filter(u -> u.getValor().getRenavam().equals(renavam)
                && u.getValor().getPlaca().equals(placa)).findFirst();

        if(no.isEmpty()){
            return "Veículo não encontrado. Confira os dados inseridos.";
        }
        return no.get().getValor().toString();
    }

    public int total(){
        return buscarTodos().size();
    }

    public Boolean verificar(String renavam, String placa){
        List<No<Veiculo>> veiculos = buscarTodos();
        var no = veiculos.stream().filter(u -> u.getValor().getRenavam().equals(renavam)
                && u.getValor().getPlaca().equals(placa)).findFirst();
        if(no.isEmpty()){
            return false;
        }
        return true;
    }

    private void inserirCinquentaVeiculos(){
        inserir(new Veiculo(new Condutor("Lucas", "987654321"), "XYZ-789", "2020", "98765432", "Civic"));
        inserir(new Veiculo(new Condutor("Carolina", "456789012"), "ABC-456", "2018", "65432109", "Corolla"));
        inserir(new Veiculo(new Condutor("Rafael", "789012345"), "DEF-123", "2019", "32109876", "Fiesta"));
        inserir(new Veiculo(new Condutor("Juliana", "234567890"), "GHI-567", "2021", "89012345", "Golf"));
        inserir(new Veiculo(new Condutor("Pedro", "890123456"), "JKL-901", "2022", "56789012", "Jetta"));
        inserir(new Veiculo(new Condutor("Mariana", "345678901"), "MNO-234", "2017", "23456789", "Mustang"));
        inserir(new Veiculo(new Condutor("André", "901234567"), "PQR-678", "2023", "90123456", "Passat"));
        inserir(new Veiculo(new Condutor("Sofia", "567890123"), "STU-345", "2015", "67890123", "Sentra"));
        inserir(new Veiculo(new Condutor("Fernando", "234567890"), "VWX-012", "2016", "34567890", "Voyage"));
        inserir(new Veiculo(new Condutor("Isabela", "678901234"), "YZA-567", "2024", "01234567", "Yaris"));
        inserir(new Veiculo(new Condutor("Eduardo", "345678901"), "BCD-890", "2013", "78901234", "Ecosport"));
        inserir(new Veiculo(new Condutor("Larissa", "012345678"), "EFG-123", "2014", "45678901", "Explorer"));
        inserir(new Veiculo(new Condutor("Gustavo", "789012345"), "HIJ-456", "2022", "12345678", "Hilux"));
        inserir(new Veiculo(new Condutor("Ana", "234567890"), "KLM-789", "2020", "89012345", "Kicks"));
        inserir(new Veiculo(new Condutor("Ricardo", "901234567"), "NOP-012", "2019", "56789012", "Nissan"));
        inserir(new Veiculo(new Condutor("Camila", "456789012"), "QRS-345", "2017", "23456789", "Qashqai"));
        inserir(new Veiculo(new Condutor("Marcelo", "890123456"), "TUV-678", "2018", "90123456", "Tucson"));
        inserir(new Veiculo(new Condutor("Vitória", "234567890"), "WXY-901", "2023", "56789012", "Wrangler"));
        inserir(new Veiculo(new Condutor("Leonardo", "345678901"), "ZAB-234", "2015", "23456789", "Zafira"));
        inserir(new Veiculo(new Condutor("Beatriz", "012345678"), "CDE-567", "2016", "67890123", "Captur"));
        inserir(new Veiculo(new Condutor("Felipe", "678901234"), "FGH-890", "2021", "34567890", "Ferrari"));
        inserir(new Veiculo(new Condutor("Laura", "345678901"), "IJK-123", "2014", "01234567", "Jeep"));
        inserir(new Veiculo(new Condutor("Rodrigo", "901234567"), "LMN-456", "2013", "78901234", "Lamborghini"));
        inserir(new Veiculo(new Condutor("Amanda", "234567890"), "OPQ-789", "2022", "45678901", "Opel"));
        inserir(new Veiculo(new Condutor("Giovanni", "789012345"), "RST-012", "2020", "12345678", "Renault"));
        inserir(new Veiculo(new Condutor("Clara", "456789012"), "UVW-345", "2019", "89012345", "Smart"));
        inserir(new Veiculo(new Condutor("Bruno", "123456789"), "XYZ-678", "2017", "56789012", "Subaru"));
        inserir(new Veiculo(new Condutor("Isadora", "890123456"), "ABC-901", "2018", "23456789", "Audi"));
        inserir(new Veiculo(new Condutor("Matheus", "567890123"), "DEF-234", "2023", "90123456", "Dodge"));
        inserir(new Veiculo(new Condutor("Lívia", "234567890"), "GHI-567", "2021", "67890123", "Genesis"));
        inserir(new Veiculo(new Condutor("Renato", "012345678"), "JKL-890", "2015", "34567890", "Jaguar"));
        inserir(new Veiculo(new Condutor("Mirella", "678901234"), "MNO-123", "2016", "01234567", "Maserati"));
        inserir(new Veiculo(new Condutor("Hugo", "345678901"), "PQR-456", "2014", "78901234", "Porsche"));
        inserir(new Veiculo(new Condutor("Natalia", "012345678"), "STU-789", "2022", "45678901", "Seat"));
        inserir(new Veiculo(new Condutor("Thiago", "901234567"), "VWX-012", "2020", "12345678", "Tesla"));
        inserir(new Veiculo(new Condutor("Luísa", "456789012"), "YZA-345", "2018", "89012345", "Toyota"));
        inserir(new Veiculo(new Condutor("Vinícius", "234567890"), "BCD-678", "2019", "56789012", "Volkswagen"));
        inserir(new Veiculo(new Condutor("Aline", "789012345"), "EFG-901", "2017", "23456789", "Alfa Romeo"));
        inserir(new Veiculo(new Condutor("Gabriel", "123456789"), "HIJ-234", "2015", "90123456", "Honda"));
        inserir(new Veiculo(new Condutor("Bianca", "234567890"), "KLM-567", "2016", "67890123", "Kia"));
        inserir(new Veiculo(new Condutor("Diego", "678901234"), "NOP-890", "2023", "34567890", "Lexus"));
        inserir(new Veiculo(new Condutor("Evelyn", "345678901"), "QRS-123", "2021", "01234567", "Mazda"));
        inserir(new Veiculo(new Condutor("Cauã", "901234567"), "TUV-456", "2014", "78901234", "Mercedes"));
        inserir(new Veiculo(new Condutor("Isabel", "234567890"), "WXY-789", "2013", "45678901", "Mini"));
        inserir(new Veiculo(new Condutor("Henrique", "345678901"), "ZAB-012", "2020", "12345678", "Nissan"));
        inserir(new Veiculo(new Condutor("Lorena", "456789012"), "CDE-345", "2019", "89012345", "Peugeot"));
        inserir(new Veiculo(new Condutor("Rafaela", "567890123"), "FGH-678", "2017", "56789012", "Renault"));
        inserir(new Veiculo(new Condutor("Guilherme", "678901234"), "IJK-901", "2018", "23456789", "Skoda"));
        inserir(new Veiculo(new Condutor("Manuela", "789012345"), "LMN-234", "2015", "90123456", "Volvo"));
        inserir(new Veiculo(new Condutor("Pedro", "890123456"), "OPQ-567", "2016", "67890123", "Jeep"));

    }
}
