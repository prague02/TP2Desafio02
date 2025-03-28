public class Funcionario {
    private String nome;
    private double salario;
    private int anosDeServico;
    private String departamento;

    public Funcionario(String nome, double salario, int anosDeServico, String departamento) {
        this.nome = nome;
        this.salario = salario;
        this.anosDeServico = anosDeServico;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAnosDeServico() {
        return anosDeServico;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return String.format("Funcionário: %s, Departamento: %s, Salário: R$%.2f", nome, departamento, salario);
    }
}
