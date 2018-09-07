import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortRecursivo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		scan.close();
	}
	
	private static void sort(int[] array) {
		sort(array, 0);
	}
	private static void sort(int[] array, int indexOfMin) {
		
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
