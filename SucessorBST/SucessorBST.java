import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class SucessorBST {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elements = getArrayInteiros(scan);
		int elem = Integer.parseInt(scan.nextLine());

		BSTSucessor<Integer> bst = new BSTSucessor<Integer>();

		for (int element : elements) {
			bst.insert(element);
		}

		System.out.println(Arrays.toString(bst.sucessor(elem)));

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

class BSTSucessor<T extends Comparable<T>> {

	private BSTNodeSucessor<T> root;

	public BSTSucessor() {
		root = new BSTNodeSucessor<T>();
	}

	public BSTNodeSucessor<T> getRoot() {
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

	public void insert(BSTNodeSucessor<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNodeSucessor<T>());
			node.setRight(new BSTNodeSucessor<T>());

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

	public BSTNodeSucessor<T> search(T element) {
		BSTNodeSucessor<T> node = null;
		if (!isEmpty()) {
			node = this.search(root, element);
		}
		return node;
	}

	private BSTNodeSucessor<T> search(BSTNodeSucessor<T> node, T element) {
		BSTNodeSucessor<T> result = new BSTNodeSucessor<T>();
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

	public BSTNodeSucessor<T> minimum() {
		BSTNodeSucessor<T> result = null;
		if (!isEmpty()) {
			result = this.minimum(root);
		}
		return result;
	}

	private BSTNodeSucessor<T> minimum(BSTNodeSucessor<T> node) {
		BSTNodeSucessor<T> result = node;
		if (!node.getLeft().isEmpty()) {
			result = minimum(node.getLeft());
		}
		return result;
	}

	private BSTNodeSucessor<T> minimum(BSTNodeSucessor<T> node, List<T> lista) {
		BSTNodeSucessor<T> result = node;
		lista.add(result.getData());
		if (!node.getLeft().isEmpty()) {
			result = minimum(node.getLeft());
			lista.add(result.getData());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public T[] sucessor(T element) {

		List<T> lista = new ArrayList<T>();
		lista.add(element);

		BSTNodeSucessor<T> node = this.search(element);

		if (!node.getRight().isEmpty()) {
			minimum(node.getRight(), lista);
		}

		else {
			BSTNodeSucessor<T> parent = node.getParent();
			while (parent != null && node.equals(parent.getRight())) {
				node = parent;
				parent = parent.getParent();
				lista.add(node.getData());
			}
			if (parent != null) {
				lista.add(parent.getData());
			}
		}

		return lista.toArray((T[]) new Comparable[lista.size()]);

	}
}

class BSTNodeSucessor<T> {

	private T data;
	private BSTNodeSucessor<T> left;
	private BSTNodeSucessor<T> right;
	private BSTNodeSucessor<T> parent;

	public BSTNodeSucessor() {

	}

	public BSTNodeSucessor(T data) {
		super();
		this.data = data;
		this.left = new BSTNodeSucessor<T>();
		this.right = new BSTNodeSucessor<T>();
		this.parent = null;
	}

	public BSTNodeSucessor(T data, BSTNodeSucessor<T> left, BSTNodeSucessor<T> right, BSTNodeSucessor<T> parent) {
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

	public BSTNodeSucessor<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNodeSucessor<T> left) {
		this.left = left;
	}

	public BSTNodeSucessor<T> getRight() {
		return right;
	}

	public void setRight(BSTNodeSucessor<T> right) {
		this.right = right;
	}

	public BSTNodeSucessor<T> getParent() {
		return parent;
	}

	public void setParent(BSTNodeSucessor<T> parent) {
		this.parent = parent;
	}
}
