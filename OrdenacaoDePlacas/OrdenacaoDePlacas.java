
import java.util.Arrays;
import java.util.Scanner;

class OrdenacaoDePlacas {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] placas = scan.nextLine().trim().split(",");
		radixSort(placas, placas.length);
		imprimePlacas(placas);
		scan.close();
	}

	private static void radixSort(String[] placas, int k) {
		int max = max(placas, k);

		for (int exp = 1; max / exp > 0; exp *= 10) {
			countingSort(placas, k, exp);
		}

	}

	private static void countingSort(String[] placas, int k, int exp) {
		String[] saida = new String[k];
		int[] contador = new int[10];
		Arrays.fill(contador, 0);

		for (int i = 0; i < k; i++) {
			contador[(getNumeroPlaca(placas[i]) / exp) % 10]++;
		}

		for (int i = 1; i < 10; i++) {
			contador[i] += contador[i - 1];
		}

		for (int i = k - 1; i >= 0; i--) {
			String placa = placas[i];
			int numeroPlaca = getNumeroPlaca(placa);
			int pos = --contador[(numeroPlaca / exp) % 10];
			saida[pos] = placas[i];
		}

		for (int i = 0; i < placas.length; i++) {
			placas[i] = saida[i];
		}
	}

	private static int getNumeroPlaca(String placa) {
		String[] result = placa.split("-");
		return Integer.parseInt(result[1]);
	}

	private static void imprimePlacas(String[] placas) {
		String result = "";
		for (int i = 0; i < placas.length - 1; i++) {
			result += placas[i] + ", ";
		}
		result += placas[placas.length - 1];
		System.out.println(result);
	}

	public static int max(String[] placas, int n) {
		String placa = placas[0];
		int max = getNumeroPlaca(placa);
		for (int i = 1; i < n; i++)
			if (getNumeroPlaca(placas[i]) > max)
				max = getNumeroPlaca(placas[i]);
		return max;
	}

}
