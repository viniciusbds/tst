import java.util.Scanner;

class FilaComLinkedList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Fila<Integer> fila = new Fila<Integer>();

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
			} else if (operacao.equals("search")) {
				int elemento = Integer.parseInt(entrada[1]);
				System.out.println(fila.search(elemento));
			}

		}

		scan.close();
	}

}

class Fila<T> {

	LinkedList<T> lista = new LinkedList<T>();

	public String print() {
		String result = "";
		if (!isEmpty()) {
			result = this.lista.toString();
		} else {
			result = "empty";
		}
		return result;
	}

	public T head() {
		T result = null;
		if (!isEmpty()) {
			result = lista.toArray()[0];
		} else {
			System.out.println("empty");
		}
		return result;
	}

	public T dequeue() {
		T result = null;
		if (!isEmpty()) {
			result = lista.toArray()[0];
			lista.removeFirst();
		} else {
			System.out.println("empty");
		}
		return result;
	}

	public void enqueue(T element) {
		this.lista.insert(element);
	}

	public int search(T elemento) {
		return this.lista.search(elemento);
	}

	public boolean isEmpty() {
		return this.lista.isEmpty();
	}

}

class LinkedList<T> {

	T data;
	LinkedList<T> next;
	LinkedList<T> previous;

	public void insert(T element) {
		if (isEmpty()) {
			this.data = element;
			this.next = new LinkedList<T>();
			if (previous == null) {
				this.previous = new LinkedList<T>();
			}
		} else {
			this.next.insert(element);
		}
	}

	public void remove(T element) {
		if (isEmpty()) {

		} else {

			if (this.data.equals(element)) {
				if (this.previous.isEmpty() && this.next.isEmpty()) {
					this.data = null;
					this.next = null;
					this.previous = null;
				} else {
					this.data = this.next.data;
					this.next = this.next.next;
					if (this.next != null) {
						this.previous = this;
					}
				}

			} else {
				this.next.remove(element);
			}

		}
	}

	public int search(T element) {
		int result = -1;
		T[] array = this.toArray();
		int i = 0;
		boolean finish = false;
		while (i < array.length && !finish) {
			if (array[i].equals(element)) {
				result = i;
				finish = true;
			}
			i++;
		}
		return result;
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			return 1 + this.next.size();
		}
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[this.size()];
		toArray(result, 0, this);
		return result;
	}

	private void toArray(T[] array, int posAtual, LinkedList<T> node) {
		if (!node.isEmpty()) {
			array[posAtual] = node.data;
			toArray(array, posAtual + 1, node.next);
		}
	}

	public String toString() {
		String result = "";
		if (isEmpty()) {

		} else {
			result = this.data + " " + this.next.toString();
		}
		return result.trim();
	}

	public void removeFirst() {
		if (!isEmpty()) {
			this.data = this.next.data;
			this.next = this.next.next;
			this.previous = new LinkedList<T>();
		}
	}

	public boolean isEmpty() {
		return this.data == null;
	}

}
