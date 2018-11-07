import java.util.Arrays;
import java.util.Scanner;

class BuildHeap {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer[] elements = getArrayInteiros(scan);

		HeapBuildHeap<Integer> heap = new HeapBuildHeap<Integer>(10);

		heap.buildHeap(elements);

		System.out.println(Arrays.toString(heap.getHeap()));
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

class HeapBuildHeap<T extends Comparable<T>> {

	protected T[] heap;
	protected int index = -1;

	@SuppressWarnings("unchecked")
	public HeapBuildHeap(int size) {
		heap = (T[]) new Comparable[size];
	}

	public void buildHeap(T[] array) {
		this.heap = array;
		this.index = array.length - 1;

		for (int i = index / 2; i >= 0; i--) {
			heapfy(i);
		}

	}

	private void heapfy(int position) {
		if (position >= 0 && position <= this.index) {

			int left = left(position);
			int right = right(position);
			int largest;

			if (left <= this.index && heap[left].compareTo(heap[position]) > 0) {
				largest = left;
			} else {
				largest = position;
			}

			if (right <= this.index && heap[right].compareTo(heap[largest]) > 0) {
				largest = right;
			}

			if (position != largest) {
				swap(heap, position, largest);
				heapfy(largest);
			}

		}
	}

	public T[] getHeap() {
		return heap;
	}

	private static int left(int i) {
		return (2 * i + 1);
	}

	private static int right(int i) {
		return (2 * i + 1) + 1;
	}

	public void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
