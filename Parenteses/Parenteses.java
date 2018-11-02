import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class Parenteses {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] entrada = scan.nextLine().split("");

		LinkedList<String> sequenciaList = new LinkedList<String>();
		for (String elemento : entrada) {
			sequenciaList.add(elemento);
		}

		if (sequenciaValida(sequenciaList)) {
			System.out.println("S");
		} else {
			System.out.println("N");
		}

		scan.close();
	}

	private static boolean sequenciaValida(LinkedList<String> sequencia) {

		if (sequencia.size() % 2 != 0 || !sequencia.peekFirst().equals("("))
			return false;

		Stack<String> pilha = new Stack<String>();
		boolean result = true;
		int i = 0;
		
		while (result && i < sequencia.size()) {
			if (sequencia.get(i).equals(")") && pilha.isEmpty()) {
				result = false;
			}

			else if (sequencia.get(i).equals("(")) {
				pilha.push(sequencia.get(i));
			}

			else {
				pilha.pop();
			}

			i++;
		}
		return result && pilha.isEmpty();
	}

}
