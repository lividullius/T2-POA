# T2-POA
Repositório para desenvolvimento do T2 de POA (Projeto e Otimização de Algoritmos).

## Estrutura

```
T2-POA/
├── problema1-subsequencia/    # Problema 1: detectar se S' é subsequência de S (greedy)
│   └── src/                   # boolean hasTrend(String[] S, String[] S_line)
├── problema2-strassen/        # Problema 2: multiplicação de matrizes de Strassen (divisão e conquista)
│   └── src/                   # int[][] multiply(int[][] A, int[][] B)
└── relatorio/                 # Relatório em pdf (capa, problema 1, problema 2)
```

## Como compilar e executar

Requer o JDK (Java 8 ou superior). Cada problema é independente e tem sua própria classe `Main` com os casos de teste.

### Problema 1 — Subsequência

```bash
cd problema1-subsequencia
javac -d bin src/*.java
java -cp bin Main
```

### Problema 2 — Strassen

```bash
cd problema2-strassen
javac -d bin src/*.java
java -cp bin Main
```

Os arquivos `.class` são gerados na pasta `bin/` de cada problema (e ignorados pelo git).

## Entregáveis
1. Relatório em pdf: capa com título e integrantes, resolução do problema 1 e do problema 2.
2. Código fonte comentado (compilável, respeitando as assinaturas pedidas).
