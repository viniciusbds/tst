import java.util.Arrays;
import java.util.Scanner;

class MatrizDeAdjacencia {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] nodes = scan.nextLine().split(" ");

		int[][] matriz = getMatrizAdjacencia(nodes, scan);

		int n = nodes.length;
		HashTableProbingLinearr tabela = new HashTableProbingLinearr(n * n);

		for (int i = 0; i < nodes.length; i++) {
			for (int j = i; j < nodes.length; j++) {
				tabela.put(nodes[i] + nodes[j], matriz[i][j]);
			}
		}

		//System.out.println(tabela);

//		String res = "";
//		for (int i = 0; i < nodes.length; i++) {
//			for (int j = 0; j < i; j++) {
//				res += 0 + " ";
//			}
//			for (int j = i; j < nodes.length; j++) {
//				res += matriz[i][j] + " ";
//			}
//			res += System.lineSeparator();
//		}
		//System.out.println(res);

		String entrada = scan.nextLine();
		String[] entradaArray = entrada.split("");
		while (!entrada.equals("fim")) {

			String ab = entradaArray[0] + entradaArray[1];

			String ba = entradaArray[1] + entradaArray[0];

			if (tabela.get(ba) != 0) {
				System.out.println(tabela.get(ba));
			} else if (tabela.get(ab) != 0) {
				System.out.println(tabela.get(ab));
			} else {
				System.out.println("aresta inexistente.");
			}

			entrada = scan.nextLine();
			entradaArray = entrada.split("");

		}

		scan.close();
	}

	private static int[][] getMatrizAdjacencia(String[] nodes, Scanner scan) {
		int[][] matriz = new int[nodes.length][nodes.length];

		String[] linha;
		for (int i = 0; i < nodes.length; i++) {
			linha = scan.nextLine().split(" ");
			for (int j = i; j < nodes.length; j++) {
				matriz[i][j] = Integer.parseInt(linha[j]);
			}
		}
		return matriz;

	}

}

class HashTableProbingLinearr {

	private Parr[] tabela;
	private int elementos;

	public HashTableProbingLinearr(int tamanho) {
		this.tabela = new Parr[tamanho];
	}

	public int get(String key) {
		int result = 0;
		if (!isEmpty()) {
			int i = 0;
			int j;
			boolean encontrou = false;
			while (i < this.tabela.length && !encontrou) {
				j = this.funcaoHash(key, i);
				if (this.tabela[j] != null && this.tabela[j].getKey().equals(key)) {
					result = this.tabela[j].getValue();
					encontrou = true;
				}
				i++;
			}
		}
		return result;
	}

	public String put(String key, Integer value) {
		if (!this.isFull()) {
			int i = 0;
			int j;
			boolean inseriu = false;
			while (i < this.tabela.length && !inseriu) {
				j = this.funcaoHash(key, i);
				if (this.tabela[j] != null && this.tabela[j].getKey() == key) {

					this.remove(key);

				}
				if (this.tabela[j] == null || this.tabela[j].isDeleted()) {
					Parr par = new Parr(key, value);
					this.tabela[j] = par;
					this.elementos++;
					inseriu = true;
				}
				i++;
			}

		}
		return this.toString();
	}

	public String remove(String key) {
		if (!isEmpty()) {
			int i = 0;
			int j;
			boolean removeu = false;
			while (i < this.tabela.length && !removeu) {
				j = this.funcaoHash(key, i);
				if (this.tabela[j] != null && this.tabela[j].getKey().equals(key)) {
					this.tabela[j].delete();
					this.elementos--;
					removeu = true;
				}
				i++;
			}
		}
		return this.toString();
	}

	public boolean isFull() {
		return this.elementos == this.tabela.length;
	}

	public boolean isEmpty() {
		return this.elementos == 0;
	}

	@Override
	public String toString() {
		return Arrays.toString(this.tabela);
	}

	public int funcaoHash(String key, int i) {
		return (key.hashCode() + i) % this.tabela.length;
	}

}

class Parr {

	String key;
	private int value;
	private boolean deleted;

	public Parr(String key, int value) {

		this.key = key;
		this.value = value;
		this.deleted = false;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void delete() {
		this.deleted = true;
	}

	public String getKey() {
		return this.key;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parr other = (Parr) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String result = null;
		if (!deleted) {
			result = "<" + this.key + ", " + this.value + ">";
		}
		return result;
	}
}
