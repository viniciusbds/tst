import java.util.Scanner;

public class FilaComLinkedList {

	Integer data;
	FilaComLinkedList next;
	FilaComLinkedList previous;

	public void adiciona(Integer element) {
		if (isEmpty()) {
			this.data = element;
			this.next = new FilaComLinkedList();
			if (previous == null) {
				this.previous = new FilaComLinkedList();
			}
		} else {
			this.next.adiciona(element);
		}
	}

	public char[] print() {
		// TODO Auto-generated method stub
		return null;
	}

	public char[] head() {
		// TODO Auto-generated method stub
		return null;
	}

	public void dequeue() {
		// TODO Auto-generated method stub

	}

	public void enqueue(int elemento) {
		// TODO Auto-generated method stub

	}

	public boolean isEmpty() {
		return this.data == null;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		FilaComLinkedList fila = new FilaComLinkedList();

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
