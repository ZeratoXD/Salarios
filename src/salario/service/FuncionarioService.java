package salario.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import salario.model.Funcionario;
import salario.repository.FuncionarioRepository;

public class FuncionarioService {
    private FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void inserirFuncionario(Funcionario funcionario) {
        repository.add(funcionario);
    }

    public void removerFuncionario(String nome) {
        Funcionario funcionario = repository.getByName(nome);
        if (funcionario != null) {
            repository.remove(funcionario);
        }
    }

    public void imprimirFuncionarios() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Funcionario func : repository.getAll()) {
            System.out.printf("Nome: %s, Data de Nascimento: %s, Salário: %,.2f, Função: %s%n",
                    func.getNome(),
                    func.getDataNascimento().format(formatter),
                    func.getSalario(),
                    func.getFuncao());
        }
    }

    public void aumentarSalario() {
        for (Funcionario func : repository.getAll()) {
            func.setSalario(func.getSalario().multiply(BigDecimal.valueOf(1.10)));
        }
    }

    public Map<String, List<Funcionario>> agruparPorFuncao() {
        return repository.getAll().stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public void imprimirAgrupadosPorFuncao() {
        Map<String, List<Funcionario>> groupedByFuncao = agruparPorFuncao();
        groupedByFuncao.forEach((funcao, funcionarios) -> {
            System.out.println("Função: " + funcao);
            funcionarios.forEach(func -> System.out.println(" - " + func.getNome()));
        });
    }

    public void imprimirAniversariantes(int... meses) {
        for (Funcionario func : repository.getAll()) {
            for (int mes : meses) {
                if (func.getDataNascimento().getMonthValue() == mes) {
                    System.out.println(func.getNome());
                }
            }
        }
    }

    public void imprimirFuncionarioMaisVelho() {
        Funcionario maisVelho = repository.getAll().stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);

        if (maisVelho != null) {
            int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
            System.out.printf("Nome: %s, Idade: %d%n", maisVelho.getNome(), idade);
        }
    }

    public void imprimirFuncionariosOrdemAlfabetica() {
        repository.getAll().stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(func -> System.out.println(func.getNome()));
    }

    public void imprimirTotalSalarios() {
        BigDecimal total = repository.getAll().stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("Total dos Salários: %,.2f%n", total);
    }

    public void imprimirSalariosMinimos(BigDecimal salarioMinimo) {
        for (Funcionario func : repository.getAll()) {
            BigDecimal salariosMinimos = func.getSalario().divide(salarioMinimo, BigDecimal.ROUND_DOWN);
            System.out.printf("%s ganha %.2f salários mínimos%n", func.getNome(), salariosMinimos);
        }
    }
}

