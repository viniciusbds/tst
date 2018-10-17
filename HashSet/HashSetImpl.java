import java.util.Arrays;
import java.util.Scanner;

class HashSetImpl {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int tamanho = Integer.parseInt(scan.nextLine());
		HashSet<Integer> conjunto = new HashSet<>(tamanho);

		Integer value;
		String entrada[];
		String operacao = "";

		while (!operacao.equals("end")) {
			entrada = scan.nextLine().split(" ");
			operacao = entrada[0];

			switch (operacao) {
			case "put":
				value = Integer.parseInt(entrada[1]);
				conjunto.put(value);
				break;

			case "remove":
				value = Integer.parseInt(entrada[1]);
				conjunto.remove(value);
				break;

			case "contains":
				value = Integer.parseInt(entrada[1]);
				System.out.println(conjunto.contains(value));
				break;
			}

		}
		scan.close();
	}

}

class HashSet<T> {

	private T[] tabela;
	private int elementos;

	public HashSet(int tamanho) {
		this.tabela = (T[]) new Object[tamanho];
		this.elementos = 0;
	}

	public void put(T value) {
		if (!isFull()) {
			int hash = this.getHash(value);

		}
		System.out.println(this.toString());
	}

	public void remove(T value) {
		if (!isEmpty()) {

		}
		System.out.println(this.toString());
	}

	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		return (this.elementos == 0);
	}

	public boolean isFull() {
		return (this.elementos == this.tabela.length);
	}

	@Override
	public String toString() {
		return Arrays.toString(this.tabela);
	}

	private int hashKey(T key) {
		return ((int) key % this.tabela.length);
	}

	private int getHash(T value) {
		int hashCode = this.hashKey(value);
		return this.probing(hashCode, 0);
	}

	private int probing(int hashCode, int probing) {
		int result = -1;
		if (probing < this.tabela.length) {
			if (this.tabela[hashCode] == null) {
				result = hashCode;
			} else {
				result = probing(hashCode, probing + 1);
			}
		}
		return result;
	}

}