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

	public Mapa(int tamanho) {
		this.tabelaDePalavras = new Palavra[tamanho];
		this.qtdPalavras = 0;
	}

	public void put(String palavra) {
		if (this)
		
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

	private int probHashFunction(int key, int i) {
		return (key + i) % this.tabelaDePalavras.length;
	}

}

class Palavra {

	private String palavra;
	private int frequencia;

	public Palavra(String palavra) {
		this.palavra = palavra;
		this.frequencia = 0;
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

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
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
