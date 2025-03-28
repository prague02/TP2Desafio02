import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Ana", 4500, 12, "RH"));
        funcionarios.add(new Funcionario("Carlos", 2500, 3, "TI"));
        funcionarios.add(new Funcionario("Maria", 3200, 8, "Financeiro"));
        funcionarios.add(new Funcionario("José", 5000, 15, "TI"));
        funcionarios.add(new Funcionario("Patrícia", 3500, 7, "Marketing"));
        funcionarios.add(new Funcionario("Lucas", 2900, 5, "Financeiro"));
        funcionarios.add(new Funcionario("Beatriz", 4000, 10, "RH"));
        funcionarios.add(new Funcionario("Fernando", 6000, 20, "TI"));
        
        System.out.println("Funcionários com salário superior a R$ 3000:");
        funcionarios.stream()
                .filter(f -> f.getSalario() > 3000)
                .forEach(f -> System.out.println(f));
                
        System.out.println("\nFuncionários com aumento de 5% no salário (mais de 10 anos de serviço):");
        funcionarios.stream()
                .filter(f -> f.getAnosDeServico() > 10)
                .forEach(f -> {
                    
                    f.setSalario(f.getSalario() * 1.05);
                    System.out.println(f);
                });

       
        System.out.println("\nFuncionários ordenados por nome:");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> System.out.println(f));

       
        double totalSalarios = funcionarios.stream()
                .mapToDouble(Funcionario::getSalario)
                .sum();
        System.out.println("\nTotal de salários pagos: R$" + totalSalarios);

        System.out.println("\nMédia de salários por departamento:");
        Map<String, Double> mediaSalariosPorDepartamento = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getDepartamento,
                        Collectors.averagingDouble(Funcionario::getSalario)));
        mediaSalariosPorDepartamento.forEach((dep, media) -> {
            System.out.println(dep + ": R$" + String.format("%.2f", media));
        });

        System.out.println("\nFuncionário com maior tempo de serviço:");
        funcionarios.stream()
                .max(Comparator.comparingInt(Funcionario::getAnosDeServico))
                .ifPresent(f -> System.out.println(f));

        System.out.println("\nFuncionários com formato personalizado:");
        funcionarios.stream()
                .forEach(f -> System.out.println(String.format("Funcionário: %s, Departamento: %s, Salário: R$%.2f", 
                        f.getNome(), f.getDepartamento(), f.getSalario())));
    }
}
