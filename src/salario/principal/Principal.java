package salario.principal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import salario.controller.FuncionarioController;
import salario.model.Funcionario;
import salario.repository.FuncionarioRepository;
import salario.service.FuncionarioService;
import salario.util.Cores;


public class Principal {
    private static FuncionarioRepository repository = new FuncionarioRepository();
    private static FuncionarioService service = new FuncionarioService(repository);
    private static FuncionarioController controller = new FuncionarioController(service);

    public static void main(String[] args) {
        List<Funcionario> funcionarios = Arrays.asList(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        );

        controller.inserirFuncionarios(funcionarios);
        menu();
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        do {
        	System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "******************************************************************************");

			System.out.println("*********************************************************************");
			System.out.println("                                                                     ");
			System.out.println("                FUNCIONARIOS LOJÃO                                   ");
			System.out.println("                                                                     ");
			System.out.println("**********************************************************************");
			System.out.println("                                                                      ");
			System.out.println("            1 - Remover o funcionário 'João'                          ");
			System.out.println("            2 - Imprimir todos os funcionários                        ");
			System.out.println("            3 - Aplicar aumento de 10% no salário dos funcionários    ");
			System.out.println("            4 - Imprimir funcionários agrupados por função            ");
			System.out.println("            5 - Imprimir funcionários que fazem aniversário nos meses 10 e 12");
			System.out.println("            6 - Imprimir funcionário com a maior idade                 ");
			System.out.println("            7 - Imprimir lista de funcionários em ordem alfabética     ");
			System.out.println("            8 - Imprimir o total dos salários                          ");
			System.out.println("            9 - Imprimir quantos salários mínimos ganha cada funcionário");
			System.out.println("                                                                        ");
			System.out.println("*************************************************************************");
			System.out.println("Entre com a opção desejada:                                              ");
			System.out.println("                                                     " + Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND);
			opcao = scanner.nextInt();
            
			switch (opcao) {
            case 1:
                service.removerFuncionario("João");
                System.out.println("Funcionário 'João' removido com sucesso.");
                break;
            case 2:
                System.out.println("Lista de todos os funcionários:");
                service.imprimirFuncionarios();
                break;
            case 3:
                service.aumentarSalario();
                System.out.println("Salário dos funcionários atualizado com aumento de 10%.");
                break;
            case 4:
                System.out.println("Funcionários agrupados por função:");
                service.imprimirAgrupadosPorFuncao();
                break;
            case 5:
                System.out.println("Funcionários que fazem aniversário nos meses 10 e 12:");
                service.imprimirAniversariantes(10, 12);
                break;
            case 6:
                System.out.println("Funcionário com a maior idade:");
                service.imprimirFuncionarioMaisVelho();
                break;
            case 7:
                System.out.println("Lista de funcionários em ordem alfabética:");
                service.imprimirFuncionariosOrdemAlfabetica();
                break;
            case 8:
                System.out.println("Total dos salários dos funcionários:");
                service.imprimirTotalSalarios();
                break;
            case 9:
                System.out.println("Quantidade de salários mínimos que cada funcionário ganha:");
                service.imprimirSalariosMinimos(new BigDecimal("1212.00"));
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }

        System.out.println();
    } while (opcao != 0);

    scanner.close();
}
}