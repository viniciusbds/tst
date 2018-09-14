
import java.util.Scanner;

class QuickSortPassoAPasso {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		quickSort(array);
		scan.close();
	}

	private static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int m = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, m - 1);
			quickSort(array, m + 1, rightIndex);
		}
	}

	private static int partition(int[] array, int leftIndex, int rightIndex) {
		int pivot = array[leftIndex];
		int i = leftIndex;
		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, leftIndex, i);
		imprimeArray(array);
		return i;
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

	private static void imprimeArray(int[] array) {
		String result = "";
		for (int i = 0; i < array.length - 1; i++) {
			result += array[i] + " ";
		}
		result += array[array.length - 1] + "";
		System.out.println(result);
	}

}
