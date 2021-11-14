public class Funcionario implements Comparable<Funcionario> {

    private int ident;
    private int filhos;
    private float salario;

    public int getIdent() { return ident; }
    public int getFilhos() { return filhos; }
    public float getSalario() { return salario; }

    public void setIdent(int ident) { this.ident = ident }
    public void setFilhos(int filhos) {
        this.filhos = filhos;
    }
    public void setSalario(float salario) {this.salario = salario; }

    @Override
    public int compareTo(Funcionario f1) {
        return Integer.compare(this.getIdent(), f1.getIdent());
    }

}
