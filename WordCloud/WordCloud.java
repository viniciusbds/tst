import java.util.Scanner;

public class WordCloud {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Mapa mapa = new Mapa(10);
		String[] frase = scan.nextLine().split(" ");
		for (String palavra : frase) {
			mapa.put(palavra);
		}
		scan.close();
	}

}

class Mapa {

	private Palavra[] tabelaDePalavras;
	private int qtdPalavras;
	private final double THRESHOLD = 0.75;

	public Mapa(int tamanho) {
		this.tabelaDePalavras = new Palavra[tamanho];
		this.qtdPalavras = 0;
	}

	public void put(String palavra) {

		if (this.contains(palavra)) {
			int i = 0;
			int j;
			boolean inseriu = false;
			while (i < this.tabelaDePalavras.length && !inseriu) {
				j = this.probHashFunction(palavra, i);
				if (this.tabelaDePalavras[j].equals(palavra)) {
					this.tabelaDePalavras[j].maisUm();
					inseriu = true;
				}
				i++;
			}
		} else {
			this.verificaCapacidade();
			int i = 0;
			int j;
			boolean inseriu = false;
			while (i < this.tabelaDePalavras.length && !inseriu) {
				j = this.probHashFunction(palavra, i);
				if (this.tabelaDePalavras[j] != null) {
					this.tabelaDePalavras[j] = new Palavra(palavra);
					inseriu = true;
				}
				i++;
			}
			this.qtdPalavras++;

		}

	}

	private void rehash(int novaCapacidade) {

		Palavra[] arrayAux = new Palavra[this.tabelaDePalavras.length];
		for (int i = 0; i < this.tabelaDePalavras.length; i++) {
			arrayAux[i] = this.tabelaDePalavras[i];
		}

		this.tabelaDePalavras = new Palavra[novaCapacidade];
		for (int i = 0; i < arrayAux.length; i++) {

			for (int j = 0; j <  arrayAux[i].getFrequencia(); j++) {
				this.put(arrayAux[i].getPalavra());
			}

		}

	}

	private void verificaCapacidade() {
		if (++this.qtdPalavras > this.tabelaDePalavras.length * this.THRESHOLD) {
			int novaCapacidade = this.getPrimeAbove(2 * this.tabelaDePalavras.length);
			this.rehash(novaCapacidade);
		}
	}

	public boolean contains(String palavra) {
		boolean contains = false;
		int i = 0;
		int j;
		while (i < this.tabelaDePalavras.length && !contains) {
			j = this.probHashFunction(palavra, i);
			if (this.tabelaDePalavras[j] != null && this.tabelaDePalavras[j].getPalavra().equals(palavra)) {
				contains = true;
			}
			i++;
		}
		return contains;
	}

	private int getPrimeAbove(int number) {
		number++;
		while (!this.isPrime(number)) {
			number++;
		}
		return number;
	}

	private static boolean isPrime(long n) {
		boolean result = true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				result = false;
				break;
			}
		}
		return result;
	}

	private int probHashFunction(String palavra, int i) {
		return (Math.abs(palavra.hashCode()) + i) % this.tabelaDePalavras.length;
	}

}

class Palavra {

	private String palavra;
	private int frequencia;

	public Palavra(String palavra) {
		this.palavra = palavra;
		this.frequencia = 0;
	}

	public Palavra(String palavra, int frequencia) {
		this.palavra = palavra;
		this.frequencia = frequencia;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public void maisUm() {
		this.frequencia++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((palavra == null) ? 0 : palavra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palavra other = (Palavra) obj;
		if (palavra == null) {
			if (other.palavra != null)
				return false;
		} else if (!palavra.equals(other.palavra))
			return false;
		return true;
	}

}
