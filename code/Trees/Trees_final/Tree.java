package Trees_final;
import LinkedList_final.List;

public interface Tree<E>{
	public Position<E> root();
	
	public Position<E> parent(Position<E> p);
	public List< Position<E> > children(Position<E> p);
	boolean isInternal(Position<E> p);
	boolean isExternal(Position<E> p);
	boolean isRoot(Position<E> p);
	int numChildren(Position<E> p);
	int size();
	boolean isEmpty();
	List<Position<E>> positions();
}
