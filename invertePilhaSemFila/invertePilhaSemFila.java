import java.util.Scanner;
import java.util.Stack;

class invertePilhaSemFila {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Stack<Integer> pilha = new Stack<Integer>();

		int tamanhoPilha = scan.nextInt();

		for (int i = 0; i < tamanhoPilha; i++) {
			pilha.push(scan.nextInt());
		}

	}

}
