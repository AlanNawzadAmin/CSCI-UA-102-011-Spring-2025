package Trees_final;
import LinkedList_final.Position;

public interface BinaryTree<E> extends Tree<E>{
	public Position<E> left(Position<E> p);
	public Position<E> right(Position<E> p);
}
