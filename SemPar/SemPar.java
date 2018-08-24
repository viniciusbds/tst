import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class SemPar {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] entrada = scan.nextLine().split(" ");
		int[] numeros = new int[entrada.length];

		for (int i = 0; i < entrada.length; i++) {
			numeros[i] = Integer.parseInt(entrada[i]);
		}
		
		System.out.println(semPar(numeros));
		scan.close();
	}

	private static int semPar(int[] vetor) {
		Set<Integer> conjunto = new HashSet<Integer>();
		for (int i = 0; i < vetor.length; i++) {
			if (!conjunto.contains(vetor[i])) {
				conjunto.add(vetor[i]);
			} else {
				conjunto.remove(vetor[i]);
			}
		}
		for (int i = 0; i < vetor.length; i++) {
			if (conjunto.contains(vetor[i])) {
				return vetor[i];
			}

		}
		return 0;
	}

}
