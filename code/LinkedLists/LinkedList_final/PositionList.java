package LinkedList_final;
import java.util.Iterator;
import java.lang.Iterable;

public abstract class PositionList<E> implements List<E>, Iterable<E>{
	private class pos_iterator implements Iterator<E>{
		Position<E> cur_pos;
		public pos_iterator() {
			cur_pos = first();
		}
		public boolean hasNext() {
			return cur_pos != null;
		}
		public E next() {
			E elem = cur_pos.getElement();
			cur_pos = after(cur_pos);
			return elem;
		}
	}
	
	public Iterator<E> iterator() {
		return new pos_iterator();
	}
	
	public abstract Position<E> first();
	public abstract Position<E> last();
	public abstract Position<E> after(Position<E> p);
	public abstract Position<E> before(Position<E> p);
	public abstract void addAfter(Position<E> p, E e);
	public abstract void addBefore(Position<E> p, E e);
	public abstract void set(Position<E> p, E e);
	public abstract E remove(Position<E> p);
}
