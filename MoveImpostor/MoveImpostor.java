import java.util.Arrays;
import java.util.Scanner;

class MoveImpostor {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		moveImpostor(array);
		System.out.println(Arrays.toString(array));
		scan.close();
	}
	
	private static void moveImpostor(int[] array) {
		int indexImpostor = getIndiceImpostor(array);
		while (indexImpostor > 0 && array[indexImpostor - 1] > array[indexImpostor] ) {
			swap(array, indexImpostor - 1, indexImpostor);
			indexImpostor--;
		}
	}
	
	private static int getIndiceImpostor(int[] array) {
		int indexImpostor = 1;
		while (array[indexImpostor - 1] <= array[indexImpostor]) {
			indexImpostor++;
		}
		return indexImpostor;
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
	
}
