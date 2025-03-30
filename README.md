# Gerenciador de Tarefas
Criado para o Bootcamp da Avanade

## Descrição

"API de gerenciamento de tarefas: o usuário pode se registrar, 
fazer login e adicionar tarefas à sua lista. Além disso, é 
possível alterar o status das tarefas para 'Em Progresso', 
'A Fazer' ou 'Concluída', bem como deletá-las conforme 
necessário.

## Entidades

```mermaid
classDiagram
    class User {
        +Long id
        +String name
        +String email
        +List~Task~ tasks
    }

    class Task {
        +Long id
        +String title
        +String description
        +boolean status
        +User user
    }

    User "1" --> "0..*" Task : has
    Task "0..1" --> "1" User : assigned to
```

## Fluxograma

```mermaid
flowchart TD
    A[Início] --> B[Usuário cria uma tarefa]
    B --> C[Tarefa criada]
    C --> D[Usuário atribui tarefa a si mesmo ou outro usuário]
    D --> E[Tarefa atribuída]
    E --> F[Usuário marca a tarefa como concluída]
    F --> G[Tarefa concluída]
    G --> H[Fim]

```