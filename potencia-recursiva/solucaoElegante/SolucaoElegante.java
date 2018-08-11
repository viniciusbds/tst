package solucaoElegante;
import java.util.Scanner;

public class SolucaoElegante {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int base = input.nextInt();
		int expoente = input.nextInt();

		System.out.println(potencia(base, expoente));

		input.close();
	}
	
	/*
	 * Esta é a potencia recursiva completa, ela aceita expoentes negativos e lança exeções quando 
	 * há indeterminação do tipo 0 elevado a 0 e divisão por 0
	 */
	public static double potencia(int base, int expoente) {

		if (base == 0 && expoente == 0 ) { throw new IllegalArgumentException("indeterminação 0^0!");}
		if (base == 0 && expoente < 0 ) { throw new IllegalArgumentException("indeterminação, divisão por zero!");}
		
		if (base == 0) { return 0; }
		if (expoente == 0) { return 1; }
		
		if(ehNegativo(expoente)) {
			double b = potencia(base, -expoente);
			return 1 / b;
		}

		if (ehPar(expoente)) {
			double baseElevadaAMetadeDoExpoente = potencia(base, expoente / 2);
			return baseElevadaAMetadeDoExpoente * baseElevadaAMetadeDoExpoente;
		}
		
		else {
			return potencia(base, expoente - 1) * base;
		}
		
	}

	private static boolean ehPar(int numero) {
		return numero % 2 == 0;
	}

	private static boolean ehNegativo(int numero) {
		return numero < 0;
	}

}
