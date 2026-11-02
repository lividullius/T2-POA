/**
 * Problema 1: verifica se S_line é subsequência de S (greedy). O(n)
 */
public class VerificaSubsequencia {
    // Elementos de S visitados na última chamada
    static int iteracoes;

    // Retorna quantas iterações a última chamada de hasTrend fez
    static int getIteracoes(){
        return iteracoes;
    }

    // Retorna true se S_line é subsequência de S
    static boolean hasTrend(String[] S, String[] S_line){
        iteracoes = 0;

        if (S == null || S_line == null) {
            return false;
        }

        int n = S.length;
        int m = S_line.length;

        // Sequência vazia é subsequência de qualquer sequência
        if (m == 0) {
            return true;
        }

        // S_line maior que S nunca pode ser subsequência
        if (m > n) {
            return false;
        }

        int j = 0; // próximo evento esperado de S_line

        for (int i = 0; i < n; i++) {
            iteracoes++;
            // Greedy: casa com a primeira ocorrência encontrada
            if (S[i].equals(S_line[j])) {
                j++;
                // Casou todos os eventos de S_line
                if (j == m) {
                    return true;
                }
            }
        }

        // Fim de S sem casar todos os eventos de S_line
        return false;
    }
}
