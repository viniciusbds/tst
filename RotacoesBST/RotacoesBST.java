import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class RotacoesBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer[] elements = getArrayInteiros(scan);

		BSt<Integer> bst = new BSt<>();
		for (int element : elements) {
			bst.insert(element);
		}

		bst.balancear();

		scan.close();
	}

	private static Integer[] getArrayInteiros(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		Integer[] array = new Integer[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}
}

class BSt<T extends Comparable<T>> {

	protected BStNode<T> root;

	public BSt() {
		root = new BStNode<T>();
	}

	public BStNode<T> getRoot() {
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

	public void insert(BStNode<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BStNode<T>());
			node.setRight(new BStNode<T>());

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

	protected int height(BStNode<T> node) {
		int result = -1;
		if (!node.isEmpty()) {
			result = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public T[] preOrder() {
		List<Comparable<T>> lista = new ArrayList<>();
		if (!isEmpty()) {
			this.preOrder(root, lista);
		}
		return (T[]) lista.toArray(new Comparable[lista.size()]);
	}

	private void preOrder(BStNode<T> node, List<Comparable<T>> lista) {
		if (!node.isEmpty()) {
			lista.add(node.getData());
			preOrder(node.getLeft(), lista);
			preOrder(node.getRight(), lista);
		}
	}

	public void balancear() {
		if (estaBalanceada()) {
			System.out.println("balanceada");
		} else {
			rebalance(root);
		}
	}

	public boolean estaBalanceada() {
		return estaBalanceada(root);
	}

	private boolean estaBalanceada(BStNode<T> node) {
		boolean balanceado = false;

		if (node.isLeaf() || node.isEmpty()) {
			balanceado = true;
		} else {
			if (nodeBalanceado(node)) {
				balanceado = true;
			} else {
				balanceado = false;
			}
			if (balanceado) {
				balanceado = estaBalanceada(node.getLeft()) && estaBalanceada(node.getRight());
			}
		}

		return balanceado;
	}

	private boolean nodeBalanceado(BStNode<T> node) {
		return Math.abs(balanceOfNode(node)) <= 1;
	}

	protected void rebalance(BStNode<T> node) {
		int balance = this.balanceOfNode(node);
		if (balance > 1) {
			if (balanceOfNode((BStNode<T>) node.getLeft()) >= 0) {
				node = rightRotation(node);
			} else {
				node.setLeft(leftRotation((BStNode<T>) node.getLeft()));
				System.out.println(Arrays.toString(this.preOrder()));
				node = rightRotation(node);
			}
			System.out.println(Arrays.toString(this.preOrder()));
		}

		else if (balance < -1) {
			if (balanceOfNode((BStNode<T>) node.getRight()) <= 0) {
				node = leftRotation(node);
			} else {
				node.setRight(rightRotation((BStNode<T>) node.getRight()));
				System.out.println(Arrays.toString(this.preOrder()));
				node = leftRotation(node);
			}
			System.out.println(Arrays.toString(this.preOrder()));
		}
	}

	private int balanceOfNode(BStNode<T> node) {
		int balance = 0;
		if (node != null && !node.isEmpty()) {
			balance = height(node.getLeft()) - height(node.getRight());
		}
		return balance;
	}

	private BStNode<T> leftRotation(BStNode<T> node) {
		BStNode<T> pivot = (BStNode<T>) node.getRight();

		if (root == node) {
			this.root = pivot;
		}

		pivot.setParent(node.getParent());

		node.setRight(pivot.getLeft());
		pivot.getLeft().setParent(node);

		pivot.setLeft(node);
		node.setParent(pivot);

		System.out.println("rot_esq(" + node.getData() + ")");
		return pivot;

	}

	private BStNode<T> rightRotation(BStNode<T> node) {
		BStNode<T> pivot = (BStNode<T>) node.getLeft();

		if (root == node) {
			this.root = pivot;
		}

		pivot.setParent(node.getParent());

		node.setLeft(pivot.getRight());
		pivot.getRight().setParent(node);

		pivot.setRight(node);
		node.setParent(pivot);

		System.out.println("rot_dir(" + node.getData() + ")");
		return pivot;
	}

}

class BStNode<T> {

	private T data;
	private BStNode<T> left;
	private BStNode<T> right;
	private BStNode<T> parent;

	public BStNode() {

	}

	public BStNode(T data) {
		super();
		this.data = data;
		this.left = new BStNode<T>();
		this.right = new BStNode<T>();
		this.parent = null;
	}

	public BStNode(T data, BStNode<T> left, BStNode<T> right, BStNode<T> parent) {
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

	public BStNode<T> getLeft() {
		return left;
	}

	public void setLeft(BStNode<T> left) {
		this.left = left;
	}

	public BStNode<T> getRight() {
		return right;
	}

	public void setRight(BStNode<T> right) {
		this.right = right;
	}

	public BStNode<T> getParent() {
		return parent;
	}

	public void setParent(BStNode<T> parent) {
		this.parent = parent;
	}

}