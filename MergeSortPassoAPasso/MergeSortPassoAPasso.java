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
		mergeSort(array, 0, array.length);
		
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

		int[] left = getArrayLeft(array, leftIndex, meio);
		int[] right = getArrayRight(array, meio + 1, rightIndex);
		int[] result = new int[rightIndex - leftIndex];

		int qtdInseridos = 0;
		int qtdElementosLeft = left.length;
		int qtdElementosRight = right.length;

		int i = 0;
		int j = 0;

		while (qtdElementosLeft > 0 && qtdElementosRight > 0) {
			if (left[i] < right[j]) {
				result[qtdInseridos++] = left[i];
				i++;
				qtdElementosLeft--;
			} else {
				result[qtdInseridos++] = right[j];
				j++;
				qtdElementosRight--;
			}
		}

		while (qtdElementosLeft > 0) {
			result[qtdInseridos] = left[i++];
			qtdElementosLeft--;
		}

		while (qtdElementosRight > 0) {
			result[qtdElementosRight] = left[j++];
			qtdElementosRight--;
		}

		int k = 0;
		for (int t = leftIndex; t < rightIndex && k < result.length; t++) {
			array[t] = result[k];
			k++;
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
