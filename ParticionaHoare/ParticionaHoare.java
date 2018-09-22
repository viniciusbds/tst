import java.util.Arrays;
import java.util.Scanner;

class ParticionaHoare {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		particionaHoare(array);
		System.out.println(Arrays.toString(array));
		scan.close();

	}

	private static void particionaHoare(int[] array) {
		particionaHoare(array, 0, array.length - 1);
	}

	private static int particionaHoare(int[] array, int leftIndex, int rightIndex) {
		int pivot = array[leftIndex];
		int i = leftIndex - 1;
		int j = rightIndex + 1;

		while (true) {
			do {
				j--;
			} while (array[j] > pivot);

			do {
				i++;
			} while (array[i] < pivot);

			if (i < j) {
				swap(array, i, j);
			} else {
				return j;
			}

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
