# Desafio: Teste prático de programação

Esta solução em Java para gestão de funcionários organiza dados em uma estrutura clara e eficiente. Com funcionalidades essenciais: https://github.com/ZeratoXD/Salarios

Features

```bash

 0 - Imprimir o total dos salários
 1 - Deletar o funcionário 'João'                          
 2 - Imprimir todos os funcionários                        
 3 - Aplicar o aumento de 10% no salário dos funcionários    
 4 - Imprimir funcionários agrupados por função            
 5 - Imprimir funcionários que fazem aniversário nos meses 10 e 12
 6 - Imprimir funcionários maior de idade               
 7 - Imprimir lista de funcionários em ordem alfabética                                                            
8 - Imprimir quantos salários mínimos ganha cada funcionário


```


### Tecnologias!

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)

#### Bibliotecas

```bash
java.math.BigDecimal
java.time.LocalDate
java.util.Arrays
java.util.List
java.util.Scanner


```

### Explicação dos metodos "Service" - Regras de negócio.



```json
Remover Funcionário:

Lógica: Remove o funcionário com o nome especificado da lista de funcionários.
Regras de Negócio: O funcionário é identificado pelo nome, e é realizada uma busca na  lista para removê-lo. A lista atualizada é salva de volta no repositório.

Imprimir Funcionários:

Lógica: Imprime todos os funcionários com a data de nascimento formatada e o salário formatado.
Regras de Negócio: Cada funcionário é exibido com a data no formato "dd/MM/yyyy" e o salário formatado com duas casas decimais.

Aumentar Salário:

Lógica: Aumenta o salário de todos os funcionários em 10%.
Regras de Negócio: Calcula um aumento de 10% para cada salário e atualiza o salário do funcionário. A lista atualizada é salva de volta no repositório.
Imprimir Funcionários Agrupados por Função:

Lógica: Agrupa os funcionários por função e imprime cada grupo.
Regras de Negócio: Os funcionários são agrupados com base na sua função. Cada grupo é exibido com a função como cabeçalho.

Imprimir Aniversariantes:

Lógica: Imprime os funcionários que fazem aniversário nos meses especificados.
Regras de Negócio: Filtra os funcionários com base no mês de nascimento e imprime aqueles que fazem aniversário nos meses fornecidos.

Imprimir Funcionário com a Maior Idade:

Lógica: Encontra o funcionário com a data de nascimento mais antiga e imprime seu nome e idade.
Regras de Negócio: Calcula a idade de cada funcionário com base na data de nascimento e encontra o funcionário mais velho.

Imprimir Funcionários em Ordem Alfabética:

Lógica: Ordena os funcionários pelo nome em ordem alfabética e imprime a lista.
Regras de Negócio: A lista de funcionários é ordenada alfabeticamente pelo nome.

Imprimir Total dos Salários:

Lógica: Calcula a soma dos salários de todos os funcionários e imprime o total.
Regras de Negócio: A soma dos salários de todos os funcionários é calculada e exibida com duas casas decimais.

Imprimir Quantos Salários Mínimos Cada Funcionário Ganha:

Lógica: Calcula quantos salários mínimos cada funcionário ganha com base no salário mínimo fornecido e imprime a quantidade.
Regras de Negócio: Divide o salário de cada funcionário pelo valor do salário mínimo para determinar quantos salários mínimos o funcionário recebe.

```

### Porque foi usado arquitetura MVC para entrega da tarefa?

```json

Usar a arquitetura MVC (Model-View-Controller) nesta solução traz várias vantagens que contribuem para um design de software robusto e eficiente:

Separação de Preocupações:

Model (Modelo): Contém a lógica de dados e regras de negócio. As classes Pessoa e Funcionario representam os dados, enquanto FuncionarioRepository gerencia a persistência.

View (Visão): Responsável pela apresentação dos dados. No nosso caso, é o menu interativo e a impressão de dados.

Controller (Controle): Atua como intermediário entre o modelo e a visão. FuncionarioController manipula os dados e atualiza a visão conforme necessário.

Manutenção Facilitada:

Modificações em uma parte do código (ex.: regras de negócio) não afetam outras partes (ex.: apresentação), tornando o sistema mais fácil de manter e evoluir.
Testabilidade:

Cada componente pode ser testado isoladamente. Por exemplo, você pode testar a lógica do FuncionarioService sem depender do menu interativo.
Reutilização de Código:

A lógica de negócio e os dados podem ser reutilizados em diferentes contextos de apresentação (ex.: GUI, CLI, web), sem necessidade de reescrever o código.
Colaboração e Desenvolvimento Paralelo:

Desenvolvedores podem trabalhar simultaneamente em diferentes componentes. Por exemplo, um desenvolvedor pode focar na lógica de negócio enquanto outro trabalha na interface de usuário.
Escalabilidade:

A arquitetura MVC permite adicionar novas funcionalidades com menos impacto no código existente, facilitando a escalabilidade do sistema.


```
