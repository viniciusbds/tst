import java.util.Arrays;
import java.util.Scanner;

class FuraFila {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		int i = Integer.parseInt(scan.nextLine());
		furaFila(array, i);
		scan.close();
	}

	private static void furaFila(int[] array, int indexPrimeiroIdoso) {

		int index = 0;
		for (int i = indexPrimeiroIdoso; i < array.length; i++) {
			int pivot = array[i];

			for (int k = i; k > index; k--) {
				array[k] = array[k - 1];
			}
			array[index] = pivot;
			index++;

			System.out.println(Arrays.toString(array));
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
