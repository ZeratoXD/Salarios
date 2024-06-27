package salario.repository;

import java.util.ArrayList;
import java.util.List;

import salario.model.Funcionario;

public class FuncionarioRepository {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void add(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void remove(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public List<Funcionario> getAll() {
        return funcionarios;
    }

    public Funcionario getByName(String nome) {
        return funcionarios.stream()
                .filter(func -> func.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }
}
