import java.util.Arrays;
import java.util.Scanner;

class ParticionaLomuto {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		particionaLomuto(array);
		System.out.println(Arrays.toString(array));
		scan.close();

	}

	private static void particionaLomuto(int[] array) {
		int pivot = array[0];
		int i = 0;
		for (int j = 1; j < array.length; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
				System.out.println(Arrays.toString(array));
			}
		}
		swap(array, 0, i);
		System.out.println(Arrays.toString(array));
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
