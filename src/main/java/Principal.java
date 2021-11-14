import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Collections;

public class Principal {

    public static void main(String[] args) {

        Path caminho = Paths.get("funcionarios.csv");
        Map<String,String> funcionarios1 = new HashMap<>(); //map guadará o identificador e o numero de filhos
        Map<String,String> funcionarios2 = new HashMap<>(); //map guardará o identificador e o salario

        ArrayList<Funcionario> funcionarios = new ArrayList<>(); //array que guardará os funcionarios que possuem filhos
        Arquivo arquivo = new Arquivo(); //criando o arquivo que irá conter os dados dos funcionarios atualizados

        try {
            List<String> conteudo = Files.readAllLines(caminho);
            conteudo.forEach((linha) -> {
                String[] linhaQuebrada = linha.split(",");
                funcionarios1.put(linhaQuebrada[0],linhaQuebrada[3]);
                funcionarios2.put(linhaQuebrada[0],linhaQuebrada[4]);
            });

            //removendo o cabeçalho do map para podermos converter os valores para int/float depois
            funcionarios1.remove("Identificador","Filhos");
            funcionarios2.remove("Identificador","Salario");

            funcionarios1.forEach((ident, filhos) -> {
                if(Integer.parseInt(filhos) > 0) { //verificando se o funcionario possui filhos
                    Funcionario func1 = new Funcionario();
                    func1.setIdent(Integer.parseInt(ident));
                    func1.setFilhos(Integer.parseInt(filhos));
                    funcionarios2.forEach((ident1, salario) ->{
                        if(ident == ident1)
                            func1.setSalario(Float.parseFloat(salario));
                    });
                    funcionarios.add(func1);
                }
            });

            Collections.sort(funcionarios); //ordenando os funcionarios pelo identificador

            //escreve os dados no novo arquivo
            for(Funcionario func2 : funcionarios){
                arquivo.escrever(func2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
