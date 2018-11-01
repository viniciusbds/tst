import java.util.LinkedList;
import java.util.Scanner;

class Parenteses {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] entrada = scan.nextLine().split("");

		LinkedList<String> sequenciaList = new LinkedList<String>();
		for (String elemento : entrada) {
			sequenciaList.add(elemento);
		}

		if (sequenciaValida(sequenciaList)) {
			System.out.println("S");
		} else {
			System.out.println("N");
		}

		scan.close();
	}

	private static boolean sequenciaValida(LinkedList<String> sequencia) {

		if (sequencia.size() % 2 != 0)
			return false;

		boolean result = true;

		String primeiro, ultimo;
		while (result && sequencia.size() > 0) {
			primeiro = sequencia.peekFirst();
			ultimo = sequencia.peekLast();
			if (!primeiro.equals("(") || primeiro.equals(ultimo)) {
				result = false;
			}
			sequencia.removeFirst();
			sequencia.removeLast();
		}

		return result;
	}

}
