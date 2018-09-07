import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		sort(array);
		scan.close();
	}

	private static void sort(int[] array) {
		sort(array, 0);
	}

	private static void sort(int[] array, int indexAtual) {
		if (indexAtual < array.length - 1) {
			int indexOfMin = indexAtual;
			for (int i = indexAtual + 1; i < array.length; i++) {
				if (array[i] < array[indexOfMin]) {
					indexOfMin = i;
				}
			}
			swap(array, indexAtual, indexOfMin);
			System.out.println(Arrays.toString(array));
			sort(array, indexAtual + 1);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int aux = array[j];
		array[j] = array[i];
		array[i] = aux;
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
