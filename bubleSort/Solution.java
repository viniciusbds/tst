import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < entrada.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		
		bubleSort(array);
		
		
		scan.close();

	}

	private static void bubleSort(int[] array) {
		boolean flag = false;
		boolean ordenado = false;
		while (!ordenado) {
			
			flag = false;
			for (int i = 1; i < array.length; i++) {
				if (array[i] < array[i - 1]) {
					int aux = array[i - 1];
					array[i - 1] = array[i];
					array[i] = aux;
					flag = true;
				}
			}

			if (!flag) {
				ordenado = true;
			}
			System.out.println(imprimeArray(array));
		}
	}

	private static String imprimeArray(int[] array) {
		String resultado = "";
		for (int i = 0; i < array.length; i++) {
			resultado += array[i] + " ";
		}
		return resultado;
	}

}
