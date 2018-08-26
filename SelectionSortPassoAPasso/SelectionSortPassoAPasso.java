import java.util.Arrays;
import java.util.Scanner;

class SelectionSortPassoAPasso {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for ( int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		sort(array);
		scan.close();
	}

	private static void sort(int[] array) {
		int indexOfMinimum;
		for (int i = 0; i < array.length; i++) {
			indexOfMinimum = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[indexOfMinimum]) {
					indexOfMinimum = j;
				}
			}
			swap(array, indexOfMinimum, i);
			if (indexOfMinimum != i) {
				System.out.println(Arrays.toString(array));
			}
		}
	}

	private static void swap(int[] array, int i, int j) {
		int aux = array[j];
		array[j] = array[i];
		array[i] = aux;
	}

}
