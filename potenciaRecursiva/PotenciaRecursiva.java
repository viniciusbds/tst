import java.util.Scanner;

class PotenciaRecursiva {

	 public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int base = input.nextInt();
		int expoente = input.nextInt();

		System.out.println(potencia(base, expoente));

		input.close();
	}
	
	public static int potencia(int base, int expoente) {

		if (base == 0) { return 0; }
		if (expoente == 0) { return 1; }
		
		if (ehPar(expoente)) {
			int baseElevadaAMetadeDoExpoente = potencia(base, expoente / 2);
			return baseElevadaAMetadeDoExpoente * baseElevadaAMetadeDoExpoente;
		}
		else {
			return potencia(base, expoente - 1) * base;
		}
		
	}

	private static boolean ehPar(int numero) {
		return numero % 2 == 0;
	}

}
