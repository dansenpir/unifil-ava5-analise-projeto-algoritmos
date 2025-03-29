# Sistema de Triagem de Pacientes - UniFil AVA5

## Sobre o Projeto

Este repositório contém a implementação da Atividade Integradora [AVA5] da disciplina Análise e Projeto de Algoritmos do curso de Engenharia de Software da Universidade Filadélfia (UniFil).

O Sistema de Triagem de Pacientes foi desenvolvido para simular e otimizar o fluxo de atendimento em ambientes de saúde, como hospitais e clínicas. Sua principal funcionalidade é a priorização de pacientes baseada na gravidade dos sintomas, seguindo as diretrizes do Protocolo de Manchester, um sistema de triagem amplamente utilizado para garantir que os pacientes mais urgentes recebam atendimento imediato. O sistema visa reduzir o tempo de espera e melhorar a eficiência do atendimento.

## Tecnologias Utilizadas

- **Java 21**: Escolhido por seus recursos avançados de concorrência (melhor gerenciamento de múltiplos pacientes simultaneamente), desempenho (processamento rápido das prioridades) e segurança (proteção dos dados sensíveis dos pacientes). A versão 21 garante acesso às últimas otimizações da linguagem.
- **Estruturas de Dados**: Fila de Prioridade (`PriorityQueue` em Java) para gerenciamento eficiente dos pacientes. Essa estrutura garante que o paciente com maior prioridade (menor tempo de espera estimado) seja sempre o próximo a ser atendido.
- **Padrões de Projeto**:
    - **Singleton**: Garante que haja apenas uma instância da Fila de Prioridade, evitando inconsistências e garantindo um ponto de acesso global para adicionar e remover pacientes.
    - **Strategy**: Permite a implementação de diferentes algoritmos de triagem (baseados no Protocolo de Manchester) de forma intercambiável, facilitando a adaptação do sistema a diferentes necessidades e protocolos.


## Estrutura do Projeto

```plaintext
src/
├── com/
│   └── hospital/
│       ├── controllers/
│       │   └── ConsoleController.java
│       ├── models/
│       │   ├── EClassificacaoRisco.java
│       │   └── Paciente.java
│       ├── services/
│       │   └── FilaPrioridade.java
│       └── utils/
│           ├── ConsoleColors.java
│           └── ValidacaoUtils.java
```


- `ConsoleController.java`: Interface do usuário via console. Responsável por receber as entradas do usuário (dados do paciente, sintomas) e exibir as informações relevantes (fila de espera, próximos pacientes a serem atendidos).
- `EClassificacaoRisco.java`: Enumeração dos níveis de risco do Protocolo de Manchester (e.g., Emergência, Muito Urgente, Urgente, Pouco Urgente, Não Urgente). Cada nível de risco corresponde a um tempo máximo de espera recomendado.
- `Paciente.java`: Modelo de dados do paciente. Contém informações como nome, idade, sintomas, e a classificação de risco atribuída.
- `FilaPrioridade.java`: Implementação da fila de prioridade utilizando a classe `PriorityQueue` do Java. A prioridade é definida pela classificação de risco do paciente.
- `ConsoleColors.java`: Utilitário para adicionar cores ao texto no console, facilitando a visualização da prioridade dos pacientes (e.g., vermelho para emergência, amarelo para urgente).
- `ValidacaoUtils.java`: Métodos para validação de dados de entrada, garantindo que os dados do paciente sejam válidos antes de serem adicionados à fila (e.g., verificar se a idade é um número positivo, se o nome não está vazio). Ajuda a prevenir erros e inconsistências no sistema.

## Funcionalidades

- Adição de pacientes à fila de atendimento: Permite adicionar novos pacientes ao sistema, coletando informações relevantes como nome, idade e sintomas.
- Classificação de risco baseada no Protocolo de Manchester: Atribui um nível de risco a cada paciente com base nos sintomas informados, utilizando a enumeração `EClassificacaoRisco`.
- Atendimento de pacientes seguindo a ordem de prioridade: Remove o paciente com maior prioridade da fila e simula o atendimento.
- Visualização da fila de atendimento atual: Exibe a lista de pacientes na fila, ordenados por prioridade, mostrando o nome e a classificação de risco de cada um.

---

Desenvolvido como parte da disciplina de Análise e Projeto de Algoritmos - Engenharia de Software - UniFil