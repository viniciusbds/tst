import java.util.Scanner;

class WarmUp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numero = Integer.parseInt(scan.nextLine());
		int[] array = getArrayInteiros(scan);
		warmUp(numero, array);
		System.out.println(arrayToString(array));
		scan.close();
	}

	private static void warmUp(int numero, int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] *= numero;
		}
	}

	private static String arrayToString(int[] array) {
		String result = "";
		for (int i = 0; i < array.length - 1; i++) {
			result += array[i] + " ";
		}
		result += array[array.length - 1] + "";
		return result;
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
