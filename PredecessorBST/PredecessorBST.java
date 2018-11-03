
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class PredecessorBST {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elements = getArrayInteiros(scan);
		int elem = Integer.parseInt(scan.nextLine());

		BSTPredecessor<Integer> bst = new BSTPredecessor<Integer>();

		for (int element : elements) {
			bst.insert(element);
		}

		System.out.println(Arrays.toString(bst.predecessor(elem)));

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

class BSTPredecessor<T extends Comparable<T>> {

	private BSTNodePredecessor<T> root;

	public BSTPredecessor() {
		root = new BSTNodePredecessor<T>();
	}

	public BSTNodePredecessor<T> getRoot() {
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

	public void insert(BSTNodePredecessor<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNodePredecessor<T>());
			node.setRight(new BSTNodePredecessor<T>());

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

	public BSTNodePredecessor<T> search(T element) {
		BSTNodePredecessor<T> node = null;
		if (!isEmpty()) {
			node = this.search(root, element);
		}
		return node;
	}

	private BSTNodePredecessor<T> search(BSTNodePredecessor<T> node, T element) {
		BSTNodePredecessor<T> result = new BSTNodePredecessor<T>();
		if (!node.isEmpty()) {

			if (element.equals(node.getData())) {
				result = node;
			}

			else if (element.compareTo(node.getData()) > 0) {
				result = this.search(node.getRight(), element);
			}

			else {
				result = this.search(node.getLeft(), element);
			}

		}
		return result;
	}

	public BSTNodePredecessor<T> maximum() {
		BSTNodePredecessor<T> result = null;
		if (!isEmpty()) {
			result = this.maximum(root);
		}
		return result;
	}

	private BSTNodePredecessor<T> maximum(BSTNodePredecessor<T> node) {
		BSTNodePredecessor<T> result = node;
		if (!node.getRight().isEmpty()) {
			result = maximum(node.getRight());
		}
		return result;
	}

	private BSTNodePredecessor<T> maximum(BSTNodePredecessor<T> node, List<T> lista) {
		BSTNodePredecessor<T> result = node;
		lista.add(result.getData());
		if (!node.getRight().isEmpty()) {
			result = maximum(node.getRight());
			lista.add(result.getData());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public T[] predecessor(T element) {

		List<T> lista = new ArrayList<T>();
		lista.add(element);

		BSTNodePredecessor<T> node = this.search(element);

		if (!node.getLeft().isEmpty()) {
			maximum(node.getLeft(), lista);
		}

		else {
			BSTNodePredecessor<T> parent = node.getParent();
			while (parent != null && node.equals(parent.getLeft())) {
				node = parent;
				lista.add(node.getData());
				parent = parent.getParent();
			}
			if (parent != null) {
				lista.add(parent.getData());
			}
		}

		return lista.toArray((T[]) new Comparable[lista.size()]);

	}
}

class BSTNodePredecessor<T> {

	private T data;
	private BSTNodePredecessor<T> left;
	private BSTNodePredecessor<T> right;
	private BSTNodePredecessor<T> parent;

	public BSTNodePredecessor() {

	}

	public BSTNodePredecessor(T data) {
		super();
		this.data = data;
		this.left = new BSTNodePredecessor<T>();
		this.right = new BSTNodePredecessor<T>();
		this.parent = null;
	}

	public BSTNodePredecessor(T data, BSTNodePredecessor<T> left, BSTNodePredecessor<T> right,
			BSTNodePredecessor<T> parent) {
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

	public BSTNodePredecessor<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNodePredecessor<T> left) {
		this.left = left;
	}

	public BSTNodePredecessor<T> getRight() {
		return right;
	}

	public void setRight(BSTNodePredecessor<T> right) {
		this.right = right;
	}

	public BSTNodePredecessor<T> getParent() {
		return parent;
	}

	public void setParent(BSTNodePredecessor<T> parent) {
		this.parent = parent;
	}
}
