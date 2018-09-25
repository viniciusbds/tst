import java.util.Scanner;

public class FilaComArray {

	private int[] array;
	private int tail;

	public FilaComArray(int tamanho) {
		this.array = new int[tamanho];
		this.tail = 0;
	}

	public void enqueue(int numero) {
		if (!isFull()) {
			array[++tail] = numero;
		}
	}

	public int dequeue() {
		int result = -1;
		if (!isEmpty()) {
			result = array[tail--];
		}
		return result;
	}

	public int head() {
		int result = -1;
		if (!isEmpty()) {
			result = array[tail];
		}
		return result;
	}

	public boolean isEmpty() {
		return tail == -1;
	}

	public boolean isFull() {
		return tail == array.length - 1;
	}

	public String print() {
		return "";
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tamanho = Integer.parseInt(scan.nextLine());
		FilaComArray fila = new FilaComArray(tamanho);

		/*
		 * 
		 * Seu programa deve imprimir o conteúdo da fila sempre que uma operação print
		 * for lida. Se a fila estiver vazia, imprima "empty". Se estiver cheia, imprima
		 * "full".
		 * 
		 * Seu programa deve imprimir o elemento inicial da fila quando ler a operação
		 * element.
		 * 
		 * Se a fila estiver vazia e for lida a operação remove, imprima "empty".
		 * 
		 * Se a fila estiver cheia e for lida a operação add, imprima "full".
		 */
		String operacao = "";
		while (!operacao.equals("end")) {

			operacao = scan.nextLine();
			if (operacao.equals("add")) {

			} else if (operacao.equals("remove")) {

			} else if (operacao.equals("element")) {

			} else if (operacao.equals("print")) {

			} else {

			}

		}

		scan.close();
	}

}
