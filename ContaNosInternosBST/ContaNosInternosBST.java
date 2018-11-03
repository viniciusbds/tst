import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ContaNosInternosBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elements = getArrayInteiros(scan);

		BSTNosInternos<Integer> bst = new BSTNosInternos<Integer>();

		for (int element : elements) {
			bst.insert(element);
		}

		System.out.println(bst.contaNosInternos());

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

class BSTNosInternos<T extends Comparable<T>> {

	private BSTNodeNosInternos<T> root;

	public BSTNosInternos() {
		root = new BSTNodeNosInternos<T>();
	}

	public BSTNodeNosInternos<T> getRoot() {
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

	public void insert(BSTNodeNosInternos<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNodeNosInternos<T>());
			node.setRight(new BSTNodeNosInternos<T>());

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

	@SuppressWarnings("unchecked")
	public T[] search(T element) {
		List<T> lista = new ArrayList<T>();
		this.search(root, element, lista);
		return lista.toArray((T[]) new Comparable[lista.size()]);
	}

	private void search(BSTNodeNosInternos<T> node, T element, List<T> lista) {
		if (!node.isEmpty()) {

			lista.add(node.getData());

			if (element.equals(node.getData())) {

			} else if (element.compareTo(node.getData()) > 0) {
				this.search(node.getRight(), element, lista);
			} else {
				this.search(node.getLeft(), element, lista);
			}

		}
	}

	public int contaNosInternos() {
		return this.contaNosInternos(root);
	}

	private int contaNosInternos(BSTNodeNosInternos<T> node) {
		int result = 0;
		if (!node.isEmpty()) {
			
			if (!node.getLeft().isLeaf() && !node.getRight().isLeaf()) {
				result = 1 + contaNosInternos(node.getLeft()) + contaNosInternos(node.getRight());
			}

			else if (!node.getLeft().isLeaf()) {
				result = 1 + contaNosInternos(node.getLeft());
			} 
			
			else if (!node.getRight().isLeaf()) {
				result = 1 + contaNosInternos(node.getRight());
			}

		}
		return result;
	}

}

class BSTNodeNosInternos<T> {

	private T data;
	private BSTNodeNosInternos<T> left;
	private BSTNodeNosInternos<T> right;
	private BSTNodeNosInternos<T> parent;

	public BSTNodeNosInternos() {

	}

	public BSTNodeNosInternos(T data) {
		super();
		this.data = data;
		this.left = new BSTNodeNosInternos<T>();
		this.right = new BSTNodeNosInternos<T>();
		this.parent = null;
	}

	public BSTNodeNosInternos(T data, BSTNodeNosInternos<T> left, BSTNodeNosInternos<T> right,
			BSTNodeNosInternos<T> parent) {
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
		return left == null && right == null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BSTNodeNosInternos<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNodeNosInternos<T> left) {
		this.left = left;
	}

	public BSTNodeNosInternos<T> getRight() {
		return right;
	}

	public void setRight(BSTNodeNosInternos<T> right) {
		this.right = right;
	}

	public BSTNodeNosInternos<T> getParent() {
		return parent;
	}

	public void setParent(BSTNodeNosInternos<T> parent) {
		this.parent = parent;
	}

}