import java.util.Scanner;

class FrequenciaElemento {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numero = Integer.parseInt(scan.nextLine());
		int[] array = getArrayInteiros(scan);
		System.out.println(frequenciaElemento(numero, array));
		scan.close();
	}

	private static int frequenciaElemento(int numero, int[] array) {
		int frequencia = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numero) {
				frequencia++;
			}
		}
		return frequencia;
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
