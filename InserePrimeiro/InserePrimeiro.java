import java.util.Arrays;
import java.util.Scanner;

class InserePrimeiro {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		inserePrimeiro(array);
		System.out.println(Arrays.toString(array));
		scan.close();
	}

	private static void inserePrimeiro(int[] array) {
		int i = 0;
		while (i < array.length - 1 && array[i + 1] < array[i]) {
			swap(array, i + 1, i);
			i++;
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

	private static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
}
