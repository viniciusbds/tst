import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HTProbingLinear {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int tamanho = Integer.parseInt(scan.nextLine());
		HashTableProbingLinear<Integer, String> tabela = new HashTableProbingLinear<>(tamanho);

		Integer key;
		String value;
		String entrada[];
		String operacao = "";

		while (!operacao.equals("end")) {
			entrada = scan.nextLine().split(" ");
			operacao = entrada[0];

			switch (operacao) {
			case "put":
				key = Integer.parseInt(entrada[1]);
				value = entrada[2];
				tabela.put(key, value);
				break;

			case "remove":
				key = Integer.parseInt(entrada[1]);
				tabela.remove(key);
				break;

			case "keys":
				System.out.println(Arrays.toString(tabela.keys()));
				break;

			case "values":
				System.out.println(Arrays.toString(tabela.values()));
				break;
			}

		}
		scan.close();
	}
}

class HashTableProbingLinear<K, V> {
	private ArrayList<Tupla<K, V>>[] tabela;
	private int elementos;

	@SuppressWarnings("unchecked")
	public HashTableProbingLinear(int tamanho) {
		this.tabela = new ArrayList[tamanho];
	}

	public void put(K key, V value) {
		if (this.elementos < this.tabela.length) {

		}
		System.out.println(this.toString());
	}

	public void remove(K key) {

		System.out.println(this.toString());
	}

	@SuppressWarnings("unchecked")
	public K[] keys() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public V[] values() {

		return null;
	}

	@Override
	public String toString() {
		return Arrays.toString(this.tabela);
	}

	public int funcaoHash(K key) {
		return (Integer) key % this.tabela.length;
	}

	private int getHash(K key) {
		int hashCode = this.funcaoHash(key);
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

class Tupla<K, V> {

	private String status;
	private K key;
	private V value;

	public Tupla(K key, V value) {
		this.status = "non-deleted";
		this.key = key;
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public K getkey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tupla<K, V> other = (Tupla<K, V>) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "<" + this.key + ", " + this.value + ">";
	}
}
