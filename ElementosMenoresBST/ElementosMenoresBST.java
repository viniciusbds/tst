import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * ainda contem bugs
 * 
 * fail: ....F.FFeee
 * 
 * 
 * @author vinicius
 *
 */
class ElementosMenoresBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elements = getArrayInteiros(scan);
		int elem = Integer.parseInt(scan.nextLine());

		BSTElementosMenores<Integer> bst = new BSTElementosMenores<Integer>();

		for (int element : elements) {
			bst.insert(element);
		}

		System.out.println(Arrays.toString(bst.preOrder()));
		System.out.println(bst.qtdMenores(elem));

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

class BSTElementosMenores<T extends Comparable<T>> {

	private BSTNodeElementosMenores<T> root;

	public BSTElementosMenores() {
		root = new BSTNodeElementosMenores<T>();
	}

	public BSTNodeElementosMenores<T> getRoot() {
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

	public void insert(BSTNodeElementosMenores<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNodeElementosMenores<T>());
			node.setRight(new BSTNodeElementosMenores<T>());

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

	public BSTNodeElementosMenores<T> search(T element) {
		BSTNodeElementosMenores<T> node = null;
		if (!isEmpty()) {
			node = this.search(root, element);
		}
		return node;
	}

	private BSTNodeElementosMenores<T> search(BSTNodeElementosMenores<T> node, T element) {
		BSTNodeElementosMenores<T> result = new BSTNodeElementosMenores<T>();
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

	private int height(BSTNodeElementosMenores<T> node) {
		int result = -1;
		if (!node.isEmpty()) {
			result = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
		}
		return result;
	}

	public int qtdMenores(T element) {
		return qtdMenores(root, element);
	}

	private int qtdMenores(BSTNodeElementosMenores<T> node, T element) {
		int result = 0;
		if (!node.isEmpty()) {
			
			if (node.getData().compareTo(element) < 0) {
				result += 1 + size(node.getLeft());
				result += qtdMenores(node.getRight(), element);
			} else {
				result += qtdMenores(node.getLeft(), element);
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

	private void preOrder(BSTNodeElementosMenores<T> node, ArrayList<Comparable<T>> lista) {
		if (!node.isEmpty()) {
			lista.add(node.getData());
			preOrder((BSTNodeElementosMenores<T>) node.getLeft(), lista);
			preOrder((BSTNodeElementosMenores<T>) node.getRight(), lista);
		}
	}

	private int size() {
		return this.size(root);
	}

	private int size(BSTNodeElementosMenores<T> node) {
		int size = 0;
		if (!node.isEmpty()) {
			size = 1 + size(node.getLeft()) + size(node.getRight());
		}
		return size;
	}

}

class BSTNodeElementosMenores<T> {

	private T data;
	private BSTNodeElementosMenores<T> left;
	private BSTNodeElementosMenores<T> right;
	private BSTNodeElementosMenores<T> parent;

	public BSTNodeElementosMenores() {

	}

	public BSTNodeElementosMenores(T data) {
		super();
		this.data = data;
		this.left = new BSTNodeElementosMenores<T>();
		this.right = new BSTNodeElementosMenores<T>();
		this.parent = null;
	}

	public BSTNodeElementosMenores(T data, BSTNodeElementosMenores<T> left, BSTNodeElementosMenores<T> right,
			BSTNodeElementosMenores<T> parent) {
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

	public BSTNodeElementosMenores<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNodeElementosMenores<T> left) {
		this.left = left;
	}

	public BSTNodeElementosMenores<T> getRight() {
		return right;
	}

	public void setRight(BSTNodeElementosMenores<T> right) {
		this.right = right;
	}

	public BSTNodeElementosMenores<T> getParent() {
		return parent;
	}

	public void setParent(BSTNodeElementosMenores<T> parent) {
		this.parent = parent;
	}

}
