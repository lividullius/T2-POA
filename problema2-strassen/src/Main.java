import java.util.Arrays;

public class Main {
    static int contador = 1;
    // Executa os casos de teste
    public static void main(String[] args) {
        // 2x2 -> [[19, 22], [43, 50]]
        int[][] A1 = {{1, 2}, {3, 4}};
        int[][] B1 = {{5, 6}, {7, 8}};
        executaTeste(A1, B1);

        // 4x4 vezes identidade -> a própria A
        int[][] A2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] I2 = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        executaTeste(A2, I2);

        // 3x3, não é potência de 2 -> [[30, 24, 18], [84, 69, 54], [138, 114, 90]]
        int[][] A3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] B3 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        executaTeste(A3, B3);

        // Retangular 2x3 vezes 3x2 -> [[58, 64], [139, 154]]
        int[][] A4 = {{1, 2, 3}, {4, 5, 6}};
        int[][] B4 = {{7, 8}, {9, 10}, {11, 12}};
        executaTeste(A4, B4);

        // Dimensões incompatíveis -> null
        executaTeste(A4, A4);

        // Valores negativos -> [[-2, 1], [-4, 1]]
        int[][] A6 = {{-1, 2}, {-3, 4}};
        int[][] B6 = {{0, 1}, {-1, 1}};
        executaTeste(A6, B6);
    }

    // Roda multiply e imprime o resultado, o número de iterações e o tempo
    public static void executaTeste(int[][] A, int[][] B){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Teste " + contador);
        System.out.println("A: " + Arrays.deepToString(A));
        System.out.println("B: " + Arrays.deepToString(B));
        System.out.println();

        long inicio = System.nanoTime();
        int[][] C = MultiplicaMatrizes.multiply(A, B);
        long fim = System.nanoTime();
        System.out.println("Resultado: " + Arrays.deepToString(C));
        System.out.println("Numero de iteracoes: " + MultiplicaMatrizes.getIteracoes());
        System.out.printf("Tempo de execucao: %.6f ms%n", (fim - inicio) / 1e6);
        contador++;
    }
}
