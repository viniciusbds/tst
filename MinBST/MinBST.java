import java.util.Scanner;

class MinBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elements = getArrayInteiros(scan);

		BSTMin<Integer> bst = new BSTMin<Integer>();

		for (int element : elements) {
			bst.insert(element);
		}

		System.out.println(bst.minimum());

		scan.close();
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

class BSTMin<T extends Comparable<T>> {

	private BSTNodeMin<T> root;

	public BSTMin() {
		root = new BSTNodeMin<T>();
	}

	public BSTNodeMin<T> getRoot() {
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

	public void insert(BSTNodeMin<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNodeMin<T>());
			node.setRight(new BSTNodeMin<T>());

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

	public String minimum() {
		return this.minimum(root).trim();
	}

	public String minimum(BSTNodeMin<T> node) {
		String result = "";
		if (!node.isEmpty()) {
			result += node.getData() + " " + minimum(node.getLeft());
		}
		return result;
	}

}

class BSTNodeMin<T> {

	private T data;
	private BSTNodeMin<T> left;
	private BSTNodeMin<T> right;
	private BSTNodeMin<T> parent;

	public BSTNodeMin() {

	}

	public BSTNodeMin(T data) {
		super();
		this.data = data;
		this.left = new BSTNodeMin<T>();
		this.right = new BSTNodeMin<T>();
		this.parent = null;
	}

	public BSTNodeMin(T data, BSTNodeMin<T> left, BSTNodeMin<T> right, BSTNodeMin<T> parent) {
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

	public BSTNodeMin<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNodeMin<T> left) {
		this.left = left;
	}

	public BSTNodeMin<T> getRight() {
		return right;
	}

	public void setRight(BSTNodeMin<T> right) {
		this.right = right;
	}

	public BSTNodeMin<T> getParent() {
		return parent;
	}

	public void setParent(BSTNodeMin<T> parent) {
		this.parent = parent;
	}

}
