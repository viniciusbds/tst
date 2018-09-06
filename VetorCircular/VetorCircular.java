import java.util.Scanner;

class VetorCircular {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		int numero = Integer.parseInt(scan.nextLine());
		System.out.println(vetorCircular(array, numero));
		scan.close();

	}

	private static String vetorCircular(int[] array, int numero) {
		String result = "";
		int index = 0;
		for (int i = 0; i < numero - 1; i++) {
			result += array[index] + " ";
			index++;
			if (index == array.length) {
				index = 0;
			}
		}
		result += array[index] + "";
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
