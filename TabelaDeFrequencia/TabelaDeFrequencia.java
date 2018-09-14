import java.util.Scanner;

class TabelaDeFrequencia {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		System.out.println(tabelaDeFrequencia(array));
		scan.close();
	}

	private static String tabelaDeFrequencia(int[] array) {
		String result = "";
		int k = max(array) - min(array);
		int[] C = new int[k + 2];
		preencheArrayNulo(C);

		for (int i = 0; i < array.length; i++) {
			C[array[i]]++;
		}

		for (int i = 0; i < array.length; i++) {

			if (C[array[i]] > 0) {
				result += array[i] + "," + C[array[i]] + " ";
				C[array[i]] = 0;
			}

		}
		if (C[array[array.length - 1]] > 0) {
			result += array[array.length - 1] + "," + C[array[array.length - 1]];
		}

		return result;
	}

	private static int[] getArrayInteiros(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}

	private static void preencheArrayNulo(int[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i] = 0;
		}
	}

	private static int max(int[] array) {
		int result = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > result) {
				result = array[i];
			}
		}
		return result;
	}

	private static int min(int[] array) {
		int result = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < result) {
				result = array[i];
			}
		}
		return result;
	}

}
