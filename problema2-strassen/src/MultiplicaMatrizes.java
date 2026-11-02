/**
 * Problema 2: multiplicação de matrizes pelo algoritmo de Strassen. O(n^2,81)
 */
public class MultiplicaMatrizes {
    // Multiplicações escalares feitas na última chamada
    static int iteracoes;

    // Retorna quantas multiplicações escalares a última chamada de multiply fez
    static int getIteracoes(){
        return iteracoes;
    }

    // Retorna A x B (null se as dimensões forem incompatíveis)
    static int[][] multiply(int[][] A, int[][] B){
        iteracoes = 0;

        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return null;
        }

        int linhasA = A.length;
        int colunasA = A[0].length;
        int linhasB = B.length;
        int colunasB = B[0].length;

        // Colunas de A devem ser iguais às linhas de B
        if (colunasA != linhasB) {
            return null;
        }

        // Completa com zeros até a próxima potência de 2
        int maior = Math.max(linhasA, Math.max(colunasA, colunasB));
        int n = 1;
        while (n < maior) {
            n *= 2;
        }

        int[][] APad = completaComZeros(A, n);
        int[][] BPad = completaComZeros(B, n);

        int[][] CPad = strassen(APad, BPad);

        // Remove os zeros adicionados
        int[][] C = new int[linhasA][colunasB];
        for (int i = 0; i < linhasA; i++) {
            for (int j = 0; j < colunasB; j++) {
                C[i][j] = CPad[i][j];
            }
        }
        return C;
    }

    // Multiplica A e B recursivamente pelo método de Strassen
    // A e B devem ser n x n, com n potência de 2
    private static int[][] strassen(int[][] A, int[][] B){
        int n = A.length;

        // Caso base: matriz 1x1 é uma multiplicação escalar
        if (n == 1) {
            iteracoes++;
            return new int[][]{{A[0][0] * B[0][0]}};
        }

        int meio = n / 2;

        // Divide A e B em quadrantes
        int[][] A11 = subMatriz(A, 0, 0, meio);
        int[][] A12 = subMatriz(A, 0, meio, meio);
        int[][] A21 = subMatriz(A, meio, 0, meio);
        int[][] A22 = subMatriz(A, meio, meio, meio);

        int[][] B11 = subMatriz(B, 0, 0, meio);
        int[][] B12 = subMatriz(B, 0, meio, meio);
        int[][] B21 = subMatriz(B, meio, 0, meio);
        int[][] B22 = subMatriz(B, meio, meio, meio);

        // 7 produtos recursivos (em vez de 8)
        int[][] M1 = strassen(soma(A11, A22), soma(B11, B22));
        int[][] M2 = strassen(soma(A21, A22), B11);
        int[][] M3 = strassen(A11, subtrai(B12, B22));
        int[][] M4 = strassen(A22, subtrai(B21, B11));
        int[][] M5 = strassen(soma(A11, A12), B22);
        int[][] M6 = strassen(subtrai(A21, A11), soma(B11, B12));
        int[][] M7 = strassen(subtrai(A12, A22), soma(B21, B22));

        // Combina os produtos nos quadrantes de C
        int[][] C11 = soma(subtrai(soma(M1, M4), M5), M7);  // A11·B11 + A12·B21
        int[][] C12 = soma(M3, M5);                         // A11·B12 + A12·B22
        int[][] C21 = soma(M2, M4);                         // A21·B11 + A22·B21
        int[][] C22 = soma(subtrai(soma(M1, M3), M2), M6);  // A21·B12 + A22·B22

        // Junta os quadrantes em uma única matriz n x n
        int[][] C = new int[n][n];
        for (int i = 0; i < meio; i++) {
            for (int j = 0; j < meio; j++) {
                C[i][j] = C11[i][j];
                C[i][j + meio] = C12[i][j];
                C[i + meio][j] = C21[i][j];
                C[i + meio][j + meio] = C22[i][j];
            }
        }
        return C;
    }

    // Retorna o quadrante tamanho x tamanho de M que começa em (linha, coluna)
    private static int[][] subMatriz(int[][] M, int linha, int coluna, int tamanho){
        int[][] sub = new int[tamanho][tamanho];
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                sub[i][j] = M[linha + i][coluna + j];
            }
        }
        return sub;
    }

    // Retorna X + Y, elemento a elemento
    private static int[][] soma(int[][] X, int[][] Y){
        int n = X.length;
        int[][] R = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                R[i][j] = X[i][j] + Y[i][j];
            }
        }
        return R;
    }

    // Retorna X - Y, elemento a elemento
    private static int[][] subtrai(int[][] X, int[][] Y){
        int n = X.length;
        int[][] R = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                R[i][j] = X[i][j] - Y[i][j];
            }
        }
        return R;
    }

    // Copia M para uma matriz n x n, posições extras ficam com zero
    private static int[][] completaComZeros(int[][] M, int n){
        int[][] R = new int[n][n];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                R[i][j] = M[i][j];
            }
        }
        return R;
    }
}
