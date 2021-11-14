import java.io.*;
import java.util.ArrayList;

public class Arquivo {

    static boolean i = true;

    public void escrever(Funcionario s1) {

        OutputStream os = null;
        OutputStreamWriter osr = null;
        BufferedWriter bw = null;
        String linhaEscrever;

        try {
            os = new FileOutputStream("func_filtrado.csv", true);
            osr = new OutputStreamWriter(os);
            bw = new BufferedWriter(osr);

            if(i == true){
                bw.write("Identificador" + "," + "Filhos" + "," + "Salario" + "\n");
                i = false;
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
