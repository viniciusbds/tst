import java.util.Scanner;
import java.util.Stack;

class NotacaoPolonesaReversa {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] formula = scan.nextLine().split(" ");
		System.out.println(solution(formula));
		scan.close();
	}

	private static double solution(String[] formula) {
		Stack<Integer> pilha = new Stack<Integer>();

		String elemento;
		for (int i = 0; i < formula.length; i++) {
			elemento = formula[i];
			if (!elemento.equals("+") && !elemento.equals("-") && !elemento.equals("*") && !elemento.equals("/")) {
				pilha.add(Integer.parseInt(elemento));
			} else {
				Integer B = pilha.pop();
				Integer A = pilha.pop();
				pilha.push(calcular(elemento, A, B));
			}
		}

		return pilha.pop();
	}

	private static int calcular(String operacao, int A, int B) {
		int result = 0;
		if (operacao.equals("+")) {
			result = A + B;
		} else if (operacao.equals("-")) {
			result = A - B;
		} else if (operacao.equals("*")) {
			result = A * B;
		} else if (operacao.equals("/")) {
			result = A / B;
		}
		return result;
	}
}
