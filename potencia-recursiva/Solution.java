import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int base = input.nextInt();
		int expoente = input.nextInt();

		System.out.println(potencia(base, expoente));

		input.close();
	}

	public static double potencia(int base, int expoente) {

		if (base == 0 && expoente <= 0 ) {
			throw new IllegalArgumentException("indeterminação!");
		}

		if (base == 0) {
			return 0;
		}

		if (expoente == 0) {
			return 1;
		}
		
		if(ehNegativo(expoente)) {
			double b = potencia(base, -expoente);
			return 1 / b;
		}

		if (ehPar(expoente)) {
			double baseElevadaAMetadeDoExpoente = potencia(base, expoente / 2);
			return baseElevadaAMetadeDoExpoente * baseElevadaAMetadeDoExpoente;
		}

		if (ehImpar(expoente)) {
			return potencia(base, expoente - 1) * base;
		}
		
		return 0;
		
	}

	private static boolean ehPar(int numero) {
		return numero % 2 == 0;
	}

	private static boolean ehImpar(int numero) {
		return !ehPar(numero);
	}
	
	private static boolean ehNegativo(int numero) {
		return numero < 0;
	}

}
