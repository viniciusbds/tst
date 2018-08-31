import java.util.Scanner;

class ElementoSobrando {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arrayMenor = getArrayInteiros(scan);
		int[] arrayMaior = getArrayInteiros(scan);
		int elemento = elementoSobrando(arrayMenor, arrayMaior);
		System.out.println(elemento);
		scan.close();
	}
	
	private static int elementoSobrando(int[] arrayMenor, int[] arrayMaior) {
		int result = 0;
		boolean achou = false;
		int i = 0;
		while (i < arrayMaior.length && !achou) {
			if (!pertence(arrayMaior[i], arrayMenor)) {
				result = arrayMaior[i];
				achou = true;
			}
			i++;
		}
		return result;
	}
	
	private static boolean pertence(int elemento, int[] array) {
		int i = 0;
		boolean result = false;
		while (!result && i < array.length) {
			if (array[i] == elemento) {
				result = true;
			}
			i++;
		}
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
