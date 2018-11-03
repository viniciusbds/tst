import java.util.Scanner;

class SomaFolhas {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elements = getArrayInteiros(scan);

		BSTSomaFolhas bst = new BSTSomaFolhas();

		for (int element : elements) {
			bst.insert(element);
		}

		System.out.println(bst.somaFolhas());

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

class BSTSomaFolhas {

	private BSTNodeSomaFolhas root;

	public BSTSomaFolhas() {
		root = new BSTNodeSomaFolhas();
	}

	public BSTNodeSomaFolhas getRoot() {
		return this.root;
	}

	public boolean isEmpty() {
		return root.isEmpty();
	}

	public void insert(Integer element) {
		if (element != null) {
			this.insert(root, element);
		}
	}

	public void insert(BSTNodeSomaFolhas node, Integer element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNodeSomaFolhas());
			node.setRight(new BSTNodeSomaFolhas());

			node.getRight().setParent(node);
			node.getLeft().setParent(node);

		} else {
			if (element > node.getData()) {
				insert(node.getRight(), element);
			} else {
				insert(node.getLeft(), element);
			}
		}
	}

	public int somaFolhas() {
		int result = 0;
		if (!isEmpty()) {
			result = this.somaFolhas(root);
		}
		return result;
	}

	private int somaFolhas(BSTNodeSomaFolhas node) {
		int result = 0;

		if (!node.isEmpty()) {

			if (node.isLeaf()) {
				result = node.getData();
			} else {
				result = somaFolhas(node.getLeft()) + somaFolhas(node.getRight());
			}

		}

		return result;
	}

}

class BSTNodeSomaFolhas {

	private Integer data;
	private BSTNodeSomaFolhas left;
	private BSTNodeSomaFolhas right;
	private BSTNodeSomaFolhas parent;

	public BSTNodeSomaFolhas() {

	}

	public BSTNodeSomaFolhas(Integer data) {
		super();
		this.data = data;
		this.left = new BSTNodeSomaFolhas();
		this.right = new BSTNodeSomaFolhas();
		this.parent = null;
	}

	public BSTNodeSomaFolhas(Integer data, BSTNodeSomaFolhas left, BSTNodeSomaFolhas right, BSTNodeSomaFolhas parent) {
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

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public BSTNodeSomaFolhas getLeft() {
		return left;
	}

	public void setLeft(BSTNodeSomaFolhas left) {
		this.left = left;
	}

	public BSTNodeSomaFolhas getRight() {
		return right;
	}

	public void setRight(BSTNodeSomaFolhas right) {
		this.right = right;
	}

	public BSTNodeSomaFolhas getParent() {
		return parent;
	}

	public void setParent(BSTNodeSomaFolhas parent) {
		this.parent = parent;
	}

}
