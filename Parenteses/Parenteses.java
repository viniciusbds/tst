import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Parenteses {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] entrada = scan.nextLine().split("");

		List<String> sequencia = new ArrayList<String>();
		for (String elemento : entrada) {
			sequencia.add(elemento);
		}
		
		if (sequenciaValida(sequencia)) {
			System.out.println("S");
		} else {
			System.out.println("N");
		}
		
		scan.close();
	}

	private static boolean sequenciaValida(List<String> sequencia) {
		
		if (sequencia.size() % 2 != 0) return false;
		
		boolean result = true;

		String primeiro, ultimo;
		while (result && sequencia.size() > 0) {
			primeiro = sequencia.get(0);
			ultimo = sequencia.get(sequencia.size() - 1);
			if (!primeiro.equals("(") || primeiro.equals(ultimo)) {
				result = false;
			}
			sequencia.remove(0);
			sequencia.remove(sequencia.size() - 1);
		}

		return result;
	}

}
