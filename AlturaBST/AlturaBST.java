import java.util.Scanner;

class AlturaBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elements = getArrayInteiros(scan);

		BSTAltura<Integer> bst = new BSTAltura<Integer>();
		for (int element : elements) {
			bst.insert(element);
		}

		System.out.println(bst.height());

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

class BSTAltura<T extends Comparable<T>> {

	private BSTNodeAltura<T> root;

	public BSTAltura() {
		root = new BSTNodeAltura<T>();
	}

	public BSTNodeAltura<T> getRoot() {
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

	public void insert(BSTNodeAltura<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNodeAltura<T>());
			node.setRight(new BSTNodeAltura<T>());

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

	public int height() {
		return this.height(root);
	}

	private int height(BSTNodeAltura<T> node) {
		int result = -1;
		if (!node.isEmpty()) {
			result = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
		}
		return result;
	}

}

class BSTNodeAltura<T> {

	private T data;
	private BSTNodeAltura<T> left;
	private BSTNodeAltura<T> right;

	public BSTNodeAltura() {

	}

	public BSTNodeAltura(T data) {
		super();
		this.data = data;
		this.left = new BSTNodeAltura<T>();
		this.right = new BSTNodeAltura<T>();
		this.parent = null;
	}

	public BSTNodeAltura(T data, BSTNodeAltura<T> left, BSTNodeAltura<T> right, BSTNodeAltura<T> parent) {
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

	public BSTNodeAltura<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNodeAltura<T> left) {
		this.left = left;
	}

	public BSTNodeAltura<T> getRight() {
		return right;
	}

	public void setRight(BSTNodeAltura<T> right) {
		this.right = right;
	}

	public BSTNodeAltura<T> getParent() {
		return parent;
	}

	public void setParent(BSTNodeAltura<T> parent) {
		this.parent = parent;
	}

	private BSTNodeAltura<T> parent;
}
