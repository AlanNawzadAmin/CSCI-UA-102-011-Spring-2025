package Recursion_final;
import LinkedList_final.Position;
import LinkedList_final.PositionList;

public class Search {
	public static<E> boolean linearSearch(PositionList<E> list, E e) {
		Position<E> current_pos = list.first();
		for(int i=0; i<list.size(); i++){
			if (current_pos.getElement().equals(e)) {
				return true;
			}
			current_pos = list.after(current_pos);
		}
		return false;
	}
	
	public boolean binarySearch(Integer[] array, int element){
//		assumes list is sorted
		int high = array.length-1;
		int low = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (element == array[mid]) return true;
			else if (element < array[mid]) {high = mid - 1;}
			else {low = mid + 1;}
		}
		return false;
	}
	
	
	
	public static<E> boolean linearSearchRecursive(PositionList<E> list, Position<E> pos, E e) {
		if (pos == null) return false;
		else if (pos.getElement().equals(e)) return true;
		else return false;
	}
	
	public static<E> boolean linearSearchRecursive(PositionList<E> list, E e) {
		return linearSearchRecursive(list, list.first(), e);
	}
	
	
	public boolean binarySearchRecursive(Integer[] array, int high, int low, int element){
		if (high < low) return false;
		int mid = (low + high) / 2;
		if (element == array[mid]) return true;
		else if (element < array[mid]) return binarySearchRecursive(array, mid-1, low, element);
		else return binarySearchRecursive(array, high, mid+1, element);
	}
	
	
	public boolean binarySearchRecursive(Integer[] array, int element){
//		assumes list is sorted
		return binarySearchRecursive(array, array.length, 0, element);
	}
}
