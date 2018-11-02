import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class BuscaBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elements = getArrayInteiros(scan);
		int elem = Integer.parseInt(scan.nextLine());

		BSTBusca<Integer> bst = new BSTBusca<Integer>();

		for (int element : elements) {
			bst.insert(element);
		}

		System.out.println(Arrays.toString(bst.search(elem)));

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

class BSTBusca<T extends Comparable<T>> {

	private BSTNodeBusca<T> root;

	public BSTBusca() {
		root = new BSTNodeBusca<T>();
	}

	public BSTNodeBusca<T> getRoot() {
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

	public void insert(BSTNodeBusca<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNodeBusca<T>());
			node.setRight(new BSTNodeBusca<T>());

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

	private void search(BSTNodeBusca<T> node, T element, List<T> lista) {
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
}

class BSTNodeBusca<T> {

	private T data;
	private BSTNodeBusca<T> left;
	private BSTNodeBusca<T> right;
	private BSTNodeBusca<T> parent;

	public BSTNodeBusca() {

	}

	public BSTNodeBusca(T data) {
		super();
		this.data = data;
		this.left = new BSTNodeBusca<T>();
		this.right = new BSTNodeBusca<T>();
		this.parent = null;
	}

	public BSTNodeBusca(T data, BSTNodeBusca<T> left, BSTNodeBusca<T> right, BSTNodeBusca<T> parent) {
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

	public BSTNodeBusca<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNodeBusca<T> left) {
		this.left = left;
	}

	public BSTNodeBusca<T> getRight() {
		return right;
	}

	public void setRight(BSTNodeBusca<T> right) {
		this.right = right;
	}

	public BSTNodeBusca<T> getParent() {
		return parent;
	}

	public void setParent(BSTNodeBusca<T> parent) {
		this.parent = parent;
	}

}
