import java.util.Arrays;
import java.util.Scanner;

class TrocaVizinhos {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		trocaVizinhos(array);
		System.out.println(Arrays.toString(array));
		scan.close();
	}

	private static void trocaVizinhos(int[] array) {
		int limite = array.length;
		if (array.length % 2 != 0) {
			limite = array.length - 1;
		}
		for (int i = 1; i < limite; i = i + 2) {
			swap(array, i, i - 1);
		}

	}

	private static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	private static int[] getArrayInteiros(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}

}
