import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ContaFolhas {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elements = getArrayInteiros(scan);

		BSTContaFolhas<Integer> bst = new BSTContaFolhas<Integer>();

		for (int element : elements) {
			bst.insert(element);
		}

		System.out.println(bst.contaFolhas());

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

class BSTContaFolhas<T extends Comparable<T>> {

	private BSTNodeContaFolhas<T> root;

	public BSTContaFolhas() {
		root = new BSTNodeContaFolhas<T>();
	}

	public BSTNodeContaFolhas<T> getRoot() {
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

	public void insert(BSTNodeContaFolhas<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNodeContaFolhas<T>());
			node.setRight(new BSTNodeContaFolhas<T>());

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

	public int contaFolhas() {
		int result = 0;
		if (!isEmpty()) {
			result = this.contaFolhas(root);
		}
		return result;
	}

	private int contaFolhas(BSTNodeContaFolhas<T> node) {
		int result = 0;

		if (!node.isEmpty()) {
			
			if (node.isLeaf()) {
				result = 1;
			} else {
				result = contaFolhas(node.getLeft()) + contaFolhas(node.getRight());
			}
			
		}

		return result;
	}

}

class BSTNodeContaFolhas<T> {

	private T data;
	private BSTNodeContaFolhas<T> left;
	private BSTNodeContaFolhas<T> right;
	private BSTNodeContaFolhas<T> parent;

	public BSTNodeContaFolhas() {

	}

	public BSTNodeContaFolhas(T data) {
		super();
		this.data = data;
		this.left = new BSTNodeContaFolhas<T>();
		this.right = new BSTNodeContaFolhas<T>();
		this.parent = null;
	}

	public BSTNodeContaFolhas(T data, BSTNodeContaFolhas<T> left, BSTNodeContaFolhas<T> right,
			BSTNodeContaFolhas<T> parent) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	public boolean isEmpty() {
		return data == null;
	}

	public boolean isLeaf() {
		return this.data != null && this.left.isEmpty() && this.right.isEmpty();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BSTNodeContaFolhas<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNodeContaFolhas<T> left) {
		this.left = left;
	}

	public BSTNodeContaFolhas<T> getRight() {
		return right;
	}

	public void setRight(BSTNodeContaFolhas<T> right) {
		this.right = right;
	}

	public BSTNodeContaFolhas<T> getParent() {
		return parent;
	}

	public void setParent(BSTNodeContaFolhas<T> parent) {
		this.parent = parent;
	}

}
