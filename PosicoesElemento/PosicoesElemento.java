import java.util.Scanner;

class PosicoesElemento {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int numero = Integer.parseInt(scan.nextLine());
		int[] array = toArray(scan.nextLine().split(" "));
		System.out.println(getPosicoesElemento(array, numero));

		scan.close();
	}

	private static String getPosicoesElemento(int[] array, int numero) {
		String result = "";
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numero) {

				if (result.isEmpty()) {
					result += i;
				} else {
					result += " " + i;
				}

			}
		}

		if (result.isEmpty()) {
			result = "-1";
		}

		return result;
	}

	private static int[] toArray(String[] sequencia) {
		int[] array = new int[sequencia.length];
		for (int i = 0; i < sequencia.length; i++) {
			array[i] = Integer.parseInt(sequencia[i]);
		}
		return array;
	}

}
