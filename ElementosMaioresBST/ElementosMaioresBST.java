import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class ElementosMaioresBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elements = getArrayInteiros(scan);
		int elem = Integer.parseInt(scan.nextLine());

		BSTElementosMaiores<Integer> bst = new BSTElementosMaiores<Integer>();

		for (int element : elements) {
			bst.insert(element);
		}

		System.out.println(Arrays.toString(bst.preOrder()));
		System.out.println(bst.qtdMaiores(elem));

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

class BSTElementosMaiores<T extends Comparable<T>> {

	private BSTNodeElementosMaiores<T> root;

	public BSTElementosMaiores() {
		root = new BSTNodeElementosMaiores<T>();
	}

	public BSTNodeElementosMaiores<T> getRoot() {
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

	public void insert(BSTNodeElementosMaiores<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNodeElementosMaiores<T>());
			node.setRight(new BSTNodeElementosMaiores<T>());

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

	public BSTNodeElementosMaiores<T> search(T element) {
		BSTNodeElementosMaiores<T> node = null;
		if (!isEmpty()) {
			node = this.search(root, element);
		}
		return node;
	}

	private BSTNodeElementosMaiores<T> search(BSTNodeElementosMaiores<T> node, T element) {
		BSTNodeElementosMaiores<T> result = new BSTNodeElementosMaiores<T>();
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

	public int height() {
		return this.height(root);
	}

	private int height(BSTNodeElementosMaiores<T> node) {
		int result = -1;
		if (!node.isEmpty()) {
			result = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
		}
		return result;
	}

	public int qtdMaiores(T element) {
		return qtdMaiores(root, element);
	}

	private int qtdMaiores(BSTNodeElementosMaiores<T> node, T element) {
		int result = 0;
		if (!node.isEmpty()) {
			
			if (node.getData().compareTo(element) > 0) {
				result += 1 + size(node.getRight());
				result += qtdMaiores(node.getLeft(), element);
			} else {
				result += qtdMaiores(node.getRight(), element);
			}
			
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public T[] preOrder() {
		ArrayList<Comparable<T>> lista = new ArrayList<>();
		if (!isEmpty()) {
			preOrder(this.root, lista);
		}
		return (T[]) lista.toArray(new Comparable[size()]);
	}

	private void preOrder(BSTNodeElementosMaiores<T> node, ArrayList<Comparable<T>> lista) {
		if (!node.isEmpty()) {
			lista.add(node.getData());
			preOrder((BSTNodeElementosMaiores<T>) node.getLeft(), lista);
			preOrder((BSTNodeElementosMaiores<T>) node.getRight(), lista);
		}
	}

	private int size() {
		return this.size(root);
	}

	private int size(BSTNodeElementosMaiores<T> node) {
		int size = 0;
		if (!node.isEmpty()) {
			size = 1 + size(node.getLeft()) + size(node.getRight());
		}
		return size;
	}

}

class BSTNodeElementosMaiores<T> {

	private T data;
	private BSTNodeElementosMaiores<T> left;
	private BSTNodeElementosMaiores<T> right;
	private BSTNodeElementosMaiores<T> parent;

	public BSTNodeElementosMaiores() {

	}

	public BSTNodeElementosMaiores(T data) {
		super();
		this.data = data;
		this.left = new BSTNodeElementosMaiores<T>();
		this.right = new BSTNodeElementosMaiores<T>();
		this.parent = null;
	}

	public BSTNodeElementosMaiores(T data, BSTNodeElementosMaiores<T> left, BSTNodeElementosMaiores<T> right,
			BSTNodeElementosMaiores<T> parent) {
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

	public BSTNodeElementosMaiores<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNodeElementosMaiores<T> left) {
		this.left = left;
	}

	public BSTNodeElementosMaiores<T> getRight() {
		return right;
	}

	public void setRight(BSTNodeElementosMaiores<T> right) {
		this.right = right;
	}

	public BSTNodeElementosMaiores<T> getParent() {
		return parent;
	}

	public void setParent(BSTNodeElementosMaiores<T> parent) {
		this.parent = parent;
	}

}
