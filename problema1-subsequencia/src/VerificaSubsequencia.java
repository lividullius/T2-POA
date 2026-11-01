/**
 * Algoritmo
 */
public class VerificaSubsequencia {
    static int iteracoes;

    static int getIteracoes(){
        return iteracoes;
    }

    static boolean hasTrend(String[] S, String[] S_line){
        iteracoes = 0;

        if (S == null || S_line == null) {
            return false;
        }

        int n = S.length;
        int m = S_line.length;

        // Sequencia vazia é subsequencia de qualquer sequencia
        if (m == 0) {
            return true;
        }

        // S_line maior que S nunca pode ser subsequencia
        if (m > n) {
            return false;
        }

        int j = 0; // ponteiro em S_line

        for (int i = 0; i < n; i++) {
            iteracoes++;
            // Se o evento atual de S é o que S_line espera, avanca em S_line
            if (S[i].equals(S_line[j])) {
                j++;
                // Casou todos os eventos de S_line
                if (j == m) {
                    return true;
                }
            }
        }

        // Chegou ao fim de S sem casar todos os eventos de S_line
        return false;
    }
}

