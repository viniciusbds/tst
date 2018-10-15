import java.util.ArrayList;
import java.util.Arrays;

/**
 * ######## NÃO CONCLUÍDO, ainda falta mt coisa : concluirei amanhã ########
 * 
 * @author Vinicius Barbosa
 *
 */
public class HashSet {

}

class TabelaHashHashSet<K, V> {

	private ArrayList<Pair<K, V>>[] tabela;
	private int elementos;

	@SuppressWarnings("unchecked")
	public TabelaHashHashSet(int tamanho) {
		this.tabela = new ArrayList[tamanho];
		for (int i = 0; i < this.tabela.length; i++) {
			this.tabela[i] = new ArrayList<Pair<K, V>>();
		}
		this.elementos = 0;
	}

	public void put(K key, V value) {

		int hash = this.funcaoHash(key);
		Pair<K, V> par = new Pair<K, V>(key, value);

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
		Pair<K, V> par = new Pair<K, V>(key, null);
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
			for (Pair<K, V> par : this.tabela[i]) {
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
			for (Pair<K, V> par : this.tabela[i]) {
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

class PairHashSet<K, V> {

	private K key;
	private V value;

	public PairHashSet(K key, V value) {
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
		PairHashSet<K, V> other = (PairHashSet<K, V>) obj;
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
