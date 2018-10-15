import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ######## NÃO CONCLUÍDO, ainda falta mt coisa : concluirei amanhã ########
 * 
 * @author Vinicius Barbosa
 *
 */
public class WordCloud {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] frase = scan.nextLine().split(" ");

		HashTable<Integer, String> frequencia = new HashTable(100);
		for (String palavra : frase) {
			frequencia.put(palavra.hashCode(), palavra);
		}
		scan.close();
	}

}

class HashTable<K, V> {

	private ArrayList<Par<K, V>>[] tabela;
	private int elementos;

	@SuppressWarnings("unchecked")
	public HashTable(int tamanho) {
		this.tabela = new ArrayList[tamanho];
		for (int i = 0; i < this.tabela.length; i++) {
			this.tabela[i] = new ArrayList<Par<K, V>>();
		}
		this.elementos = 0;
	}

	public void put(K key, V value) {

		int hash = this.funcaoHash(key);
		Par<K, V> par = new Par<K, V>(key, value);

		if (!this.tabela[hash].contains(par)) {
			this.tabela[hash].add(par);
			this.elementos++;
		} else {
			this.replaceValue(hash, key, value);
		}

		System.out.println(this.toString());
	}

	private void replaceValue(int hash, K key, V value) {
		boolean finish = false;
		int index = 0;
		while (index < this.tabela.length && !finish) {
			if (this.tabela[hash].get(index).getkey().equals(key)) {
				this.tabela[hash].get(index).setValue(value);
				finish = true;
			}
			index++;
		}
	}

	public void remove(K key) {
		int hash = this.funcaoHash(key);
		Par<K, V> par = new Par<K, V>(key, null);
		if (this.tabela[hash].contains(par)) {
			this.tabela[hash].remove(par);
			this.elementos--;
		}
		System.out.println(this.toString());
	}

	@SuppressWarnings("unchecked")
	public K[] keys() {
		int index = 0;
		K[] keys = (K[]) new Object[this.elementos];
		for (int i = 0; i < this.tabela.length; i++) {
			for (Par<K, V> par : this.tabela[i]) {
				keys[index++] = par.getkey();
			}
		}
		Arrays.sort(keys);
		return keys;
	}

	@SuppressWarnings("unchecked")
	public V[] values() {
		int index = 0;
		V[] values = (V[]) new Object[this.elementos];
		for (int i = 0; i < this.tabela.length; i++) {
			for (Par<K, V> par : this.tabela[i]) {
				values[index++] = par.getValue();
			}
		}
		Arrays.sort(values);
		return values;
	}

	public int funcaoHash(K key) {
		return (Integer) key % this.tabela.length;
	}

	@Override
	public String toString() {
		return Arrays.toString(this.tabela);
	}

}

class Par<K, V> {

	private K key;
	private V value;

	public Par(K key, V value) {
		this.key = key;
		this.value = value;
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
		Par<K, V> other = (Par<K, V>) obj;
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