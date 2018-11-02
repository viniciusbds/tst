import java.util.Scanner;

class MaxBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elements = getArrayInteiros(scan);

		BSTMax<Integer> bst = new BSTMax<Integer>();

		for (int element : elements) {
			bst.insert(element);
		}

		System.out.println(bst.maximum());

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

class BSTMax<T extends Comparable<T>> {

	private BSTNodeMax<T> root;

	public BSTMax() {
		root = new BSTNodeMax<T>();
	}

	public BSTNodeMax<T> getRoot() {
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

	public void insert(BSTNodeMax<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNodeMax<T>());
			node.setRight(new BSTNodeMax<T>());

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

	public String maximum() {
		return this.maximum(root).trim();
	}

	public String maximum(BSTNodeMax<T> node) {
		String result = "";
		if (!node.isEmpty()) {
			result += node.getData() + " " + maximum(node.getRight());
		}
		return result;
	}

}

class BSTNodeMax<T> {

	private T data;
	private BSTNodeMax<T> left;
	private BSTNodeMax<T> right;
	private BSTNodeMax<T> parent;

	public BSTNodeMax() {

	}

	public BSTNodeMax(T data) {
		super();
		this.data = data;
		this.left = new BSTNodeMax<T>();
		this.right = new BSTNodeMax<T>();
		this.parent = null;
	}

	public BSTNodeMax(T data, BSTNodeMax<T> left, BSTNodeMax<T> right, BSTNodeMax<T> parent) {
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

	public BSTNodeMax<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNodeMax<T> left) {
		this.left = left;
	}

	public BSTNodeMax<T> getRight() {
		return right;
	}

	public void setRight(BSTNodeMax<T> right) {
		this.right = right;
	}

	public BSTNodeMax<T> getParent() {
		return parent;
	}

	public void setParent(BSTNodeMax<T> parent) {
		this.parent = parent;
	}

}
