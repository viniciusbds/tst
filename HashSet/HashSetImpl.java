import java.util.Arrays;
import java.util.Scanner;

class HashSetImpl {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int tamanho = Integer.parseInt(scan.nextLine());
		HashSetInteger conjunto = new HashSetInteger(tamanho);

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

class HashSetInteger {

	private Celula[] tabela;
	private int elementos;

	public HashSetInteger(int tamanho) {
		this.tabela = new Celula[tamanho];
		this.elementos = 0;
	}

	public void put(int value) {
		if (!isFull() && !this.contains(value)) {
			int i = 0;
			int j;

			boolean inseriu = false;
			while (i < this.tabela.length && !inseriu) {
				j = this.probFunction(value, i);
				if (this.tabela[j] == null || this.tabela[j].isDeleted()) {
					this.tabela[j] = new Celula(value);
					this.elementos++;
					inseriu = true;
				}
				i++;
			}
		}
		System.out.println(this.toString());
	}

	public void remove(int value) {
		if (this.contains(value)) {
			int i = 0;
			int j = this.probFunction(value, i);

			boolean removeu = false;

			while (i < this.tabela.length && this.tabela[j] != null && !removeu) {
				j = this.probFunction(value, i);
				if (this.tabela[j].getValue() == value) {
					this.tabela[j].delete();
					this.elementos--;
					removeu = true;
				}
				i++;
			}
		}
		System.out.println(this.toString());
	}

	public boolean contains(int value) {
		boolean contains = false;
		if (!isEmpty()) {
			int i = 0;
			while (i < this.tabela.length - 1 && !contains) {
				int j = this.probFunction(value, i);
				if (this.tabela[j] != null && !this.tabela[j].isDeleted()) {
					if (this.tabela[j].getValue() == value) {
						contains = true;
					}
				}
				i++;
			}
		}
		return contains;
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

	private int probFunction(int k, int i) {
		return (k + i) % this.tabela.length;
	}

}

class Celula {

	private Integer value;
	private boolean deleted;

	public Celula(Integer valor) {
		this.value = valor;
		this.deleted = false;
	}

	public void delete() {
		this.deleted = true;
	}

	public boolean isDeleted() {
		return this.deleted;
	}

	public Integer getValue() {
		return value;
	}

	@Override
	public String toString() {
		String result = null;
		if (!this.deleted) {
			result = this.value + "";
		}
		return result;
	}

}