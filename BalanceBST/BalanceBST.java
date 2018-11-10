import java.util.Scanner;

class BalanceBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer[] elements = getArrayInteiros(scan);

		BsT<Integer> bst = new BsT<Integer>();
		for (int element : elements) {
			bst.insert(element);
		}

		System.out.println(bst.balance());
		scan.close();
	}

	private static Integer[] getArrayInteiros(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		Integer[] array = new Integer[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}

}

class BsT<T extends Comparable<T>> {

	private BSTNodee<T> root;

	public BsT() {
		root = new BSTNodee<T>();
	}

	public BSTNodee<T> getRoot() {
		return this.root;
	}

	public boolean isEmpty() {
		return root.isEmpty();
	}

	public void insert(T element) {
		if (element != null) {
			this.insert(root, element);
		}
	}

	public void insert(BSTNodee<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNodee<T>());
			node.setRight(new BSTNodee<T>());

			node.getRight().setParent(node);
			node.getLeft().setParent(node);

		} else {
			if (element.compareTo(node.getData()) > 0) {
				insert(node.getRight(), element);
			} else {
				insert(node.getLeft(), element);
			}
		}
	}

	public String balance() {
		String result = "";
		if (!isEmpty()) {
			result = balance(root);
		}
		return result.trim();
	}

	private String balance(BSTNodee<T> node) {
		String result = "";
		if (!node.isEmpty()) {
			result += node.getData() + "," + balanceOfNode(node) + " ";
			result += balance(node.getLeft());
			result += balance(node.getRight());
		}
		return result;
	}

	private int balanceOfNode(BSTNodee<T> node) {
		int balance = 0;
		if (!node.isEmpty()) {
			balance = height(node.getLeft()) - height(node.getRight());
		}
		return balance;
	}

	private int height(BSTNodee<T> node) {
		int result = -1;
		if (!node.isEmpty()) {
			result = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
		}
		return result;
	}

}

class BSTNodee<T> {

	private T data;
	private BSTNodee<T> left;
	private BSTNodee<T> right;
	private BSTNodee<T> parent;

	public BSTNodee() {

	}

	public BSTNodee(T data) {
		super();
		this.data = data;
		this.left = new BSTNodee<T>();
		this.right = new BSTNodee<T>();
		this.parent = null;
	}

	public BSTNodee(T data, BSTNodee<T> left, BSTNodee<T> right, BSTNodee<T> parent) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	public boolean isEmpty() {
		return data == null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BSTNodee<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNodee<T> left) {
		this.left = left;
	}

	public BSTNodee<T> getRight() {
		return right;
	}

	public void setRight(BSTNodee<T> right) {
		this.right = right;
	}

	public BSTNodee<T> getParent() {
		return parent;
	}

	public void setParent(BSTNodee<T> parent) {
		this.parent = parent;
	}

}
