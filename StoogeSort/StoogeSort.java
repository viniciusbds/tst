import java.util.Scanner;

class StoogeSort {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		stoogeSort(array);
		imprimeArray(array);
		scan.close();

	}

	private static void stoogeSort(int[] array) {
		stoogeSort(array, 0, array.length - 1);

	}

	private static void stoogeSort(int[] array, int leftIndex, int rightIndex) {
		if (array[rightIndex] < array[leftIndex]) {
			swap(array, leftIndex, rightIndex);
		}

		if (rightIndex - leftIndex > 1) {
			int t = (int) Math.floor((rightIndex - leftIndex + 1) / 3);
			stoogeSort(array, leftIndex, rightIndex - t);
			stoogeSort(array, leftIndex + t, rightIndex);
			stoogeSort(array, leftIndex, rightIndex - t);
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

	private static void imprimeArray(int[] array) {
		String result = "";
		for (int i = 0; i < array.length - 1; i++) {
			result += array[i] + " ";
		}
		result += array[array.length - 1] + "";
		System.out.println(result);
	}

}
