package StackQueues;

public class ArrayQueue<E> {
	public static int MAX_SIZE = 1000;
	E array[];
	int end;
	int start;
	
	public ArrayQueue(){
		array = (E[ ]) new Object[MAX_SIZE];
	}
	
	public void enqueue(E element) {
		array[end%MAX_SIZE] = element;
		end++;
	}
	public E dequeue() {
		if (size() == 0) return null;
		else {
			E return_ = array[start%MAX_SIZE];
			array[start%MAX_SIZE] = null;
			start++;
			return return_;
		}
	}
	public int size() {
		return end - start;
	}
}
