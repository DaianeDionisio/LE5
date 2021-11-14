import java.io.*;
import java.util.ArrayList;

public class Arquivo {

    public void escrever(Funcionario s1) {

        OutputStream os = null;
        OutputStreamWriter osr = null;
        BufferedWriter bw = null;
        String linhaEscrever;

        //sera necessario ler o arquivo para verificar quando ele esta em branco e inserir o cabeçalho
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        ArrayList<Funcionario> acheiNoArquivo = new ArrayList<>();
        String linhaLer;

        try {
            os = new FileOutputStream("func_filtrado.csv", true);
            osr = new OutputStreamWriter(os);
            bw = new BufferedWriter(osr);

            is = new FileInputStream("func_filtrado.csv");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            linhaLer = br.readLine();

            if(linhaLer == null){
                bw.write("Identificador" + "," + "Filhos" + "," + "Salario" + "\n");
            }
            bw.write(s1.getIdent() + ",");
            bw.write(s1.getFilhos() + ",");
            bw.write(s1.getSalario() + "\n");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
