package LinkedList_final;

public interface PositionList<E> extends List<E>{
	public Position<E> first();
	public Position<E> last();
	public Position<E> after(Position<E> p);
	public Position<E> before(Position<E> p);
	public void addAfter(Position<E> p, E e);
	public void addBefore(Position<E> p, E e);
	public void set(Position<E> p, E e);
	public E remove(Position<E> p);
}
