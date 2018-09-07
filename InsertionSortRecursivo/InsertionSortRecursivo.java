import java.util.Arrays;
import java.util.Scanner;

class InsertionSortRecursivo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		sort(array);
		scan.close();
	}

	private static void sort(int[] array) {
		sort(array, 1);
	}

	private static void sort(int[] array, int i) {
		if (i < array.length) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
			System.out.println(Arrays.toString(array));
			sort(array, i + 1);
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

}
