import java.util.Scanner;

class BubbleSort {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		int[] array = preencheArray();

		bubleSort(array);

		scan.close();

	}

	private static void bubleSort(int[] array) {

		boolean flag = false;
		boolean ordenado = arrayOrdenado(array);

		if (ordenado) {
			System.out.println(imprimeArray(array));
		} else {
			while (!ordenado) {
				flag = false;
				for (int i = 1; i < array.length; i++) {
					if (array[i] < array[i - 1]) {
						swap(array, i, i - 1);
						flag = true;
					}
				}
				if (!flag) {
					ordenado = true;
				} else {
					System.out.println(imprimeArray(array));
				}

			}
		}
	}

	private static boolean arrayOrdenado(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	private static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	

	private static String imprimeArray(int[] array) {
		String resultado = "";

		int i;
		for (i = 0; i < array.length - 1; i++) {
			resultado += array[i] + " ";
		}
		resultado += array[array.length - 1] + "";

		return resultado;
	}
	
	public static int[] preencheArray() {
		String[] linha = scan.nextLine().split(" ");
		int[] numeros = new int[linha.length];
		for (int i = 0; i < linha.length; i++) {
			numeros[i] = Integer.parseInt(linha[i]);
		}
		return numeros;
	}

}
