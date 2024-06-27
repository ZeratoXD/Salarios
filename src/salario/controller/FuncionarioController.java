package salario.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import salario.model.Funcionario;
import salario.service.FuncionarioService;

public class FuncionarioController {
    private FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    public void inserirFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario func : funcionarios) {
            service.inserirFuncionario(func);
        }
    }

    public void executarAcoes() {
        service.removerFuncionario("João");
        service.imprimirFuncionarios();
        service.aumentarSalario();
        service.imprimirFuncionarios();
        service.imprimirAgrupadosPorFuncao();
        service.imprimirAniversariantes(10, 12);
        service.imprimirFuncionarioMaisVelho();
        service.imprimirFuncionariosOrdemAlfabetica();
        service.imprimirTotalSalarios();
        service.imprimirSalariosMinimos(new BigDecimal("1212.00"));
    }
}
