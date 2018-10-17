import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Erro na deleção !!!
 * 
 * @author viniciusbds
 *
 */
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
		if (!isFull()) {
			int i = 0;
			int j;

			boolean inseriu = false;
			while (i < this.tabela.length && !inseriu) {
				j = this.probFunction(value, i);
				if (this.tabela[j] == null || this.tabela[j].isDeleted()) {
					this.tabela[j] = new Celula(value);
					inseriu = true;
				}
				i++;
			}
		}
		System.out.println(this.toString());
	}

	public void remove(int value) {
		if (!isEmpty()) {
			int i = 0;
			int j = this.probing(value, i++);
			while (i < this.tabela.length && !this.tabela[j].getValue().equals(value)) {
				j = this.probing(value, i);
				i++;
			}
			if (i < this.tabela.length) {
				this.tabela[j].delete();
			}
		}
		System.out.println(this.toString());
	}

	public boolean contains(Integer value) {
		boolean contains = false;
		if (!isEmpty()) {

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

	private int getHash(Integer value) {
		return this.probing((int) value, 0);
	}

	private int probFunction(int k, int i) {
		return (this.funcaoLinear(k) + i) % this.tabela.length;
	}

	private int funcaoLinear(int k) {
		return k % 5;
	}

	private int probing(int k, int i) {

		int index = this.probFunction(k, i);

		if (i >= this.tabela.length) {
			return -1;
		} else {
			if (this.tabela[index] == null) {
				return index;
			} else {
				return this.probing(k, i + 1);
			}
		}
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

	public void setValor(Integer valor) {
		this.value = valor;
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