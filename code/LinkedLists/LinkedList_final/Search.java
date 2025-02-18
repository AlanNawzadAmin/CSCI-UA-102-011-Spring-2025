package LinkedList_final;

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
	
	public boolean binarySearch(PositionList<Integer> list, int element){
//		assumes list is sorted
		int high = list.size()-1;
		int low = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (element == list.getAtIndex(mid)) return true;
			else if (element < list.getAtIndex(mid)) {high = mid - 1;}
			else {low = mid + 1;}
		}
		return false;
	}
}
