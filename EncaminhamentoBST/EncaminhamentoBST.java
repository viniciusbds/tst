import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class EncaminhamentoBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elements = getArrayInteiros(scan);

		BST<Integer> bst = new BST<Integer>();

		for (int element : elements) {
			bst.insert(element);
		}

		System.out.println(Arrays.toString(bst.preOrder()));
		System.out.println(Arrays.toString(bst.order()));
		System.out.println(Arrays.toString(bst.posOrder()));
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

class BST<T extends Comparable<T>> {

	private BSTNode<T> root;

	public BST() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
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

	public void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());

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
	public T[] preOrder() {
		List<Comparable<T>> lista = new ArrayList<>();
		if (!isEmpty()) {
			this.preOrder(root, lista);
		}
		return (T[]) lista.toArray(new Comparable[lista.size()]);
	}

	private void preOrder(BSTNode<T> node, List<Comparable<T>> lista) {
		if (!node.isEmpty()) {
			lista.add(node.getData());
			preOrder(node.getLeft(), lista);
			preOrder(node.getRight(), lista);
		}
	}

	@SuppressWarnings("unchecked")
	public T[] order() {
		List<Comparable<T>> lista = new ArrayList<>();
		if (!isEmpty()) {
			this.order(root, lista);
		}
		return (T[]) lista.toArray(new Comparable[lista.size()]);
	}

	private void order(BSTNode<T> node, List<Comparable<T>> lista) {
		if (!node.isEmpty()) {
			order(node.getLeft(), lista);
			lista.add(node.getData());
			order(node.getRight(), lista);
		}
	}

	@SuppressWarnings("unchecked")
	public T[] posOrder() {
		List<Comparable<T>> lista = new ArrayList<>();
		if (!isEmpty()) {
			this.posOrder(root, lista);
		}
		return (T[]) lista.toArray(new Comparable[lista.size()]);
	}

	private void posOrder(BSTNode<T> node, List<Comparable<T>> lista) {
		if (!node.isEmpty()) {
			posOrder(node.getLeft(), lista);
			posOrder(node.getRight(), lista);
			lista.add(node.getData());
		}
	}

}

class BSTNode<T> {

	private T data;
	private BSTNode<T> left;
	private BSTNode<T> right;
	private BSTNode<T> parent;

	public BSTNode() {

	}

	public BSTNode(T data) {
		super();
		this.data = data;
		this.left = new BSTNode<T>();
		this.right = new BSTNode<T>();
		this.parent = null;
	}

	public BSTNode(T data, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent) {
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

	public BSTNode<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}

	public BSTNode<T> getRight() {
		return right;
	}

	public void setRight(BSTNode<T> right) {
		this.right = right;
	}

	public BSTNode<T> getParent() {
		return parent;
	}

	public void setParent(BSTNode<T> parent) {
		this.parent = parent;
	}

}
