import java.util.Scanner;

class FilaComArray {

	private int[] array;
	private int tail;

	public FilaComArray(int tamanho) {
		this.array = new int[tamanho];
		this.tail = -1;
	}

	public void enqueue(int elemento) {
		if (!isFull()) {
			this.array[++tail] = elemento;
		} else {
			System.out.println("full");
		}
	}

	public int dequeue() {
		int result = -1;
		if (!isEmpty()) {
			result = array[0];
			shiftLeft();
			this.tail--;
		} else {
			System.out.println("empty");
		}
		return result;
	}

	private void shiftLeft() {
		for (int i = 0; i < tail; i++) {
			array[i] = array[i + 1];
		}

	}

	public String head() {
		String result = "empty";
		if (!isEmpty()) {
			result = "" + array[tail];
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
		String result = "empty";
		if (!isEmpty()) {
			result = "";
			for (int i = 0; i < tail; i++) {
				result += array[i] + " ";
			}
			result += array[tail] + "";
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int tamanho = Integer.parseInt(scan.nextLine());
		FilaComArray fila = new FilaComArray(tamanho);

		String[] entrada;
		String operacao = "";
		while (!operacao.equals("end")) {

			entrada = scan.nextLine().split(" ");
			operacao = entrada[0];

			if (operacao.equals("add")) {
				int elemento = Integer.parseInt(entrada[1]);
				fila.enqueue(elemento);
			} else if (operacao.equals("remove")) {
				fila.dequeue();
			} else if (operacao.equals("element")) {
				System.out.println(fila.head());
			} else if (operacao.equals("print")) {
				System.out.println(fila.print());
			}

		}

		scan.close();
	}

}
