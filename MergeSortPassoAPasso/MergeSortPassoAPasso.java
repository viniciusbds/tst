import java.util.Arrays;
import java.util.Scanner;

class MergeSortPassoAPasso {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		mergeSort(array);
		System.out.println(Arrays.toString(array));
		scan.close();
	}

	private static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);

	}

	private static void mergeSort(int[] array, int leftIndex, int rightIndex) {
		imprimeArray(array, leftIndex, rightIndex);
		if (leftIndex < rightIndex) {

			int meio = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, meio);
			mergeSort(array, meio + 1, rightIndex);
			merge(array, leftIndex, meio, rightIndex);

			if (rightIndex - leftIndex < array.length-1) {
				imprimeArray(array, leftIndex, rightIndex);
			}

		}
	}

	private static void merge(int[] array, int leftIndex, int meio, int rightIndex) {
		int[] aux = Arrays.copyOf(array, array.length);

		int i = leftIndex;
		int j = meio + 1;
		int indexAtual = leftIndex;

		while (i <= meio && j <= rightIndex) {
			if (aux[i] < aux[j]) {
				array[indexAtual] = aux[i];
				i++;
			} else {
				array[indexAtual] = aux[j];
				j++;
			}
			indexAtual++;
		}

		while (i <= meio) {
			array[indexAtual] = aux[i];
			i++;
			indexAtual++;
		}

		while (j <= rightIndex) {
			array[indexAtual] = aux[j];
			j++;
			indexAtual++;
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

	private static void imprimeArray(int[] array, int leftIndex, int rightIndex) {
		System.out.println(Arrays.toString(Arrays.copyOfRange(array, leftIndex, rightIndex + 1)));
	}

}
