import java.util.Scanner;

class PilhaComArray {

	private int[] array;
	private int top;

	public PilhaComArray(int tamanho) {
		array = new int[tamanho];
		top = -1;
	}

	public void push(int elemento) {
		if (top < array.length - 1) {
			array[++top] = elemento;
		} else {
			System.out.println("full");
		}
	}

	public int pop() {
		int result = -1;
		if (!isEmpty()) {
			top--;
			result = array[top + 1];
		}
		return result;
	}

	public int peak() {
		int result = -1;
		if (!isEmpty()) {
			result = array[top];
		}
		return result;
	}

	public String print() {
		String result = "empty";
		if (!isEmpty()) {
			result = "";
			for (int i = 0; i < top; i++) {
				result += array[i] + " ";
			}
			result += array[top] + "";
		}
		return result;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * Mainzão.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tamanho = Integer.parseInt(scan.nextLine());
		PilhaComArray pilha = new PilhaComArray(tamanho);

		String operacao = "";
		while (!operacao.equals("end")) {
		
			operacao = scan.nextLine();
			if (operacao.equals("pop")) {
				int i = pilha.pop();
				if (i == -1) {
					System.out.println("empty");
				}
			} else if (operacao.equals("peek")) {
				System.out.println(pilha.peak());
			} else if (operacao.equals("print")) {
				System.out.println(pilha.print());
			} else {
				String[] op = operacao.split(" ");
				if (op[0].equals("push")) {
					pilha.push(Integer.parseInt(op[1]));
				}
			}
			
		}

		scan.close();
	}

}
