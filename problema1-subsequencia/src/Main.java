import java.util.Arrays;

public class Main {
    static int contador = 1;
    // Executa os casos de teste
    public static void main(String[] args) {
        String[] S = {"buy Amazon", "buy Google", "buy Apple",
                      "buy Google", "buy Google", "buy NVIDIA"};

        // Exemplo do enunciado -> true
        String[] t1 = {"buy Google", "buy Apple", "buy Google", "buy NVIDIA"};
        executaTeste(S, t1);

        // Ordem errada -> false
        String[] t2 = {"buy Apple", "buy NVIDIA", "buy Google"};
        executaTeste(S, t2);

        // Sequência vazia -> true
        executaTeste(S, new String[]{});

        // Evento inexistente -> false
        String[] t4 = {"sell Google"};
        executaTeste(S, t4);

        // Igual a S -> true
        executaTeste(S, S);
    }

    // Roda hasTrend e imprime o resultado, o número de iterações e o tempo
    public static void executaTeste(String[] S, String[] S_line){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Teste " + contador);
        System.out.println("S: " + Arrays.toString(S));
        System.out.println("S': " + Arrays.toString(S_line));
        System.out.println();

        long inicio = System.nanoTime();
        boolean hasTrend = VerificaSubsequencia.hasTrend(S, S_line);
        long fim = System.nanoTime();
        System.out.println("Resultado: " + hasTrend);
        System.out.println("Numero de iteracoes: " + VerificaSubsequencia.getIteracoes());
        System.out.printf("Tempo de execucao: %.6f ms%n", (fim - inicio) / 1e6);
        contador++;
    }
}
