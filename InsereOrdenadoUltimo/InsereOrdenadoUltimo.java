import java.util.Arrays;
import java.util.Scanner;

class InsereOrdenadoUltimo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		insereUltimo(array);
		System.out.println(Arrays.toString(array));
		scan.close();
	}

	private static void insereUltimo(int[] array) {
		boolean estaOrdenado = false;
		int i = array.length - 1;
		while (!estaOrdenado && i > 0) {
			if (array[i] < array[i - 1]) {
				swap(array, i, i - 1);
				i--;
			} else {
				estaOrdenado = true;
			}
		}
	}

	private static int[] getArrayInteiros(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}

	private static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
}
