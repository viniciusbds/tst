import java.util.Scanner;

class TeoremaMestre {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int ord = scan.nextInt();
		String result = teoremaMestre(a, b, ord);
		System.out.println(result);
		scan.close();
	}

	private static String teoremaMestre(int a, int b, int ord) {
		String result = "T(n) = theta(";

		double log = Math.log(a) / Math.log(b);
		if (log < ord) {
			result += "n**" + ord;
		} else if (log > ord) {
			
		} else {
			result += "n**" + ord + " * log n";
		}

		result += ")";
		return result;
	}

}
