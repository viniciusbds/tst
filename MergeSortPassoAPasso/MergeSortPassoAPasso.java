import java.util.Arrays;
import java.util.Scanner;

public class MergeSortPassoAPasso {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] array = { 5, 4, 3, 2, 1 };// getArrayInteiros(scan);
		mergeSort(array);
		System.out.println(Arrays.toString(array));
		scan.close();
	}

	private static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);

	}

	private static void mergeSort(int[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {

			int meio = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, meio);
			mergeSort(array, meio + 1, rightIndex);
			merge(array, leftIndex, meio, rightIndex);
		}

	}

	private static void merge(int[] array, int leftIndex, int meio, int rightIndex) {

		int n1 = meio - leftIndex + 1;
		int n2 = rightIndex - meio;

		int[] left = new int[n1];
		for (int i = 0; i < n1; i++) {
			left[i] = array[i];
		}
		int[] right = new int[n2];
		for (int j = 0; j < n2; j++) {
			right[j] = array[j + meio + 1];
		}

		int i = 0;
		int j = 0;
		int indexAtual = leftIndex;

		while (i < n1 && j < n2) {
			if (array[i] < array[j]) {
				array[indexAtual] = left[i];
				i++;
			} else {
				array[indexAtual] = right[j];
				j++;
			}
			indexAtual++;
		}

		while (i < n1) {
			array[indexAtual] = left[i];
			i++;
			indexAtual++;
		}

		while (j < n2) {
			array[indexAtual] = right[j];
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

	private static int[] getArrayLeft(int[] array, int leftIndex, int meio) {
		int[] result = new int[meio];
		int k = 0;
		for (int i = leftIndex; i <= meio && k < result.length; i++) {
			result[k] = array[i];
			k++;
		}
		return result;
	}

	private static int[] getArrayRight(int[] array, int meio, int rightIndex) {
		int[] result = new int[meio];
		int k = 0;
		for (int i = meio; i <= rightIndex && k < result.length; i++) {
			result[k] = array[i];
			k++;
		}
		return result;
	}
}
