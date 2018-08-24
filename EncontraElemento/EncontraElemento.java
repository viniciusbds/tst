import java.util.Scanner;

class EncontraElemento {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int elemento = Integer.parseInt(scan.nextLine());
		String[] listaString = scan.nextLine().split(" ");

		int[] array = new int[listaString.length];
		for (int i = 0; i < listaString.length; i++) {
			array[i] = Integer.parseInt(listaString[i]);
		}

		if (contem(elemento, array)) {
			System.out.println("sim");
		} else {
			System.out.println("nao");
		}

		scan.close();
	}

	private static boolean contem(int elemento, int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == elemento) {
				return true;
			}
		}
		return false;
	}

}
