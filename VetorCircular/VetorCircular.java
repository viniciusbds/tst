import java.util.Scanner;

class VetorCircular {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		int quantidadeElementos = Integer.parseInt(scan.nextLine());
		System.out.println(vetorCircular(array, quantidadeElementos));
		scan.close();
	}

	private static String vetorCircular(int[] array, int quantidadeElementos) {
		String result = "";
		int index = 0;
		for (int i = 0; i < quantidadeElementos - 1; i++) {
			result += array[index % array.length] + " ";
			index++;
		}
		result += array[index % array.length];
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
