import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class RemocaoBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elementosInseridos = getArrayInteiros(scan);
		int[] elementosQueSeraoRemovidos = getArrayInteiros(scan);
		Bst<Integer> bst = new Bst<Integer>();

		for (int element : elementosInseridos) {
			bst.insert(element);
		}

		for (int element : elementosQueSeraoRemovidos) {
			bst.remove(element);
		}

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

class Bst<T extends Comparable<T>> {

	private BstNode<T> root;

	public Bst() {
		root = new BstNode<T>();
	}

	public BstNode<T> getRoot() {
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

	public void insert(BstNode<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BstNode<T>());
			node.setRight(new BstNode<T>());

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

	public void remove(T element) {
		BstNode<T> node = search(element);
		if (node != null) {
			remove(node);
		}
		if (this.preOrder().length == 0) {
			System.out.println("null");
		} else {
			System.out.println(Arrays.toString(this.preOrder()));
		}
	}

	private void remove(BstNode<T> node) {
		if (!node.isEmpty()) {

			if (node.isLeaf()) {
				node.setData(null);
				node.setLeft(null);
				node.setRight(null);
			}

			else if (hasOneChild(node)) {

				BstNode<T> child = node.getLeft();
				if (child == null) {
					child = node.getRight();
				}

				if (node == root) {
					root = child;
				} else {

					if (isLeftChild(node)) {

						if (!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
						} else {
							node.getParent().setLeft(node.getRight());
						}

					}

					else {

						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
						} else {
							node.getParent().setRight(node.getRight());
						}

					}

					node.setData(child.getData());
						
				}

			} else {
				BstNode<T> sucessor = this.sucessor(node.getData());
				node.setData(sucessor.getData());
				remove(sucessor);
			}
		}

	}

	private boolean hasOneChild(BstNode<T> node) {
		return !node.getLeft().isEmpty() && node.getRight().isEmpty()
				|| node.getLeft().isEmpty() && !node.getRight().isEmpty();
	}

	private boolean isLeftChild(BstNode<T> node) {
		return node.getParent() != null && node.getParent().getLeft() == node;
	}

	public BstNode<T> search(T element) {
		BstNode<T> node = null;
		if (!isEmpty()) {
			node = this.search(root, element);
		}
		return node;
	}

	private BstNode<T> search(BstNode<T> node, T element) {
		BstNode<T> result = new BstNode<T>();
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

	public BstNode<T> minimum() {
		BstNode<T> result = null;
		if (!isEmpty()) {
			result = this.minimum(root);
		}
		return result;
	}

	private BstNode<T> minimum(BstNode<T> node) {
		BstNode<T> result = node;
		if (!node.getLeft().isEmpty()) {
			result = minimum(node.getLeft());
		}
		return result;
	}

	public BstNode<T> sucessor(T element) {

		BstNode<T> sucessor;

		BstNode<T> node = this.search(element);

		if (!node.getRight().isEmpty()) {
			sucessor = minimum(node.getRight());
		}

		else {
			BstNode<T> parent = node.getParent();
			while (parent != null && node.equals(parent.getRight())) {
				node = parent;
				parent = parent.getParent();
			}
			sucessor = parent;
		}

		return sucessor;

	}

	@SuppressWarnings("unchecked")
	public T[] preOrder() {
		List<Comparable<T>> lista = new ArrayList<>();
		if (!isEmpty()) {
			this.preOrder(root, lista);
		}
		return (T[]) lista.toArray(new Comparable[lista.size()]);
	}

	private void preOrder(BstNode<T> node, List<Comparable<T>> lista) {
		if (!node.isEmpty()) {
			lista.add(node.getData());
			preOrder(node.getLeft(), lista);
			preOrder(node.getRight(), lista);
		}
	}
}

class BstNode<T> {

	private T data;
	private BstNode<T> left;
	private BstNode<T> right;
	private BstNode<T> parent;

	public BstNode() {

	}

	public BstNode(T data) {
		super();
		this.data = data;
		this.left = new BstNode<T>();
		this.right = new BstNode<T>();
		this.parent = null;
	}

	public BstNode(T data, BstNode<T> left, BstNode<T> right, BstNode<T> parent) {
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

	public BstNode<T> getLeft() {
		return left;
	}

	public void setLeft(BstNode<T> left) {
		this.left = left;
	}

	public BstNode<T> getRight() {
		return right;
	}

	public void setRight(BstNode<T> right) {
		this.right = right;
	}

	public BstNode<T> getParent() {
		return parent;
	}

	public void setParent(BstNode<T> parent) {
		this.parent = parent;
	}
}
