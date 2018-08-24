import java.util.Scanner;
import java.util.Stack;

class InverteFrase {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Stack<String> stack = new Stack<String>();
		String frase = scan.nextLine();
		String palavra = "";
		for (int i = 0; i < frase.length(); i++) {
			if (Character.isSpaceChar(frase.charAt(i))) {
				stack.push(palavra);
				palavra = "";
			} else {
				palavra += frase.charAt(i);
			}
		}
		stack.push(palavra);
		
		
		String fraseInvertida = "";
		while (!stack.isEmpty()){
			fraseInvertida += stack.pop() + " ";
		}
		fraseInvertida = fraseInvertida.trim();
		System.out.println(fraseInvertida);

		scan.close();
	}

}
