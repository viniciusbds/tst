import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class InvertePilha {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Stack<Integer> pilha = new Stack<Integer>();
		Queue<Integer> fila = new LinkedList<Integer>();
		Stack<Integer> pilhaInvertida = new Stack<Integer>();
		int tamanhoPilha = scan.nextInt();

		for (int i = 0; i < tamanhoPilha; i++) {
			pilha.push(scan.nextInt());
		}

		while (!pilha.isEmpty()) {
			fila.add(pilha.pop());
		}

		while (!fila.isEmpty()) {
			pilhaInvertida.push(fila.remove());
		}

		imprimePilha(pilhaInvertida);

		scan.close();
	}

	private static void imprimePilha(Stack<Integer> pilha) {
		while (!pilha.isEmpty()) {
			System.out.println(pilha.pop());
		}
	}

}
