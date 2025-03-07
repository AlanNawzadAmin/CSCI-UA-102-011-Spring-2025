package Trees_final;

import LinkedList_final.DoublyLinkedList;
import LinkedList_final.Position;
import LinkedList_final.PositionList;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
	protected static class Node<E> implements Position<E>{
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
		
		public E getElement(){return element;}
		public Node<E> getParent() {return parent;}
		public Position<E> getLeft() {return left;}
		public Position<E> getRight() {return right;}
		public void setLeft(Node<E> pos) {this.left = pos;}
		public void setRight(Node<E> pos) {this.right = pos;}
	}
	
	protected Node<E> validate_position(Position<E> p){
		if(p instanceof Node<E>)
			return (Node<E>)p;
		else
			throw new IllegalArgumentException();
	}
	
	protected Node<E> root;
	protected int size;
 	public LinkedBinaryTree() {
	}
	public LinkedBinaryTree(E root_element) {
		root = new Node<E>(root_element, null);
	}
	
	public Position<E> root(){ return root;}
	
	public Position<E> left(Position<E> p){ return validate_position(p).getLeft();}
	public Position<E> right(Position<E> p){ return validate_position(p).getRight();}
	public Position<E> parent(Position<E> p){ return validate_position(p).getParent();}
	public PositionList< Position<E> > children(Position<E> p){
		PositionList<Position<E>> list = new DoublyLinkedList<Position<E>>();
		if (left(p)!= null) list.addLast(left(p));
		if (right(p)!= null) list.addLast(right(p));
		return list;
	}
	public int numChildren(Position<E> p) {
		return children(p).size();
	}
	public boolean isInternal(Position<E> p) {
		return numChildren(p) != 0;
	}
	public boolean isExternal(Position<E> p) {
		return !isInternal(p);
	}
	public boolean isRoot(Position<E> p) {
		return p == root;
	}
	public int size() {return size;}
	public boolean isEmpty() { return size == 0;}
	
	public int depth(Position<E> p) {
		if (isRoot(p)) return 0;
		return depth(parent(p)) + 1;
	}
	public int height(Position<E> p) {
		if (p == null) return -1;
		else {
			return Math.max(height(left(p)), height(right(p))) + 1;
		}
	}
	
	public PositionList<Position<E>> positions(){
		PositionList<Position<E>> list = new DoublyLinkedList<Position<E>>();
		preorderPositions(root, list);
		return list;
	}
	
	private void preorderPositions(Position<E> p, PositionList<Position<E>> list){
		if (p != null) {
			list.addLast(p);
			preorderPositions(left(p), list);
			preorderPositions(right(p), list);
		}
	};
	
	private void postorderPositions(Position<E> p, PositionList<Position<E>> list){
		if (p != null) {
			postorderPositions(left(p), list);
			postorderPositions(right(p), list);
			list.addLast(p);
		}
	};
	
	private void inorderPositions(Position<E> p, PositionList<Position<E>> list){
		if (p != null) {
			inorderPositions(left(p), list);
			list.addLast(p);
			inorderPositions(right(p), list);
		}
	};
	
	private Object[] isBalancedHelper(Position<E> p){
		if (p == null) {
			return new Object[] {true, -1};
		}
		else {
			Object[] left_calc = isBalancedHelper(left(p));
			boolean left_balanced = (boolean)left_calc[0];
			int h_l = (int)left_calc[1];
			
			Object[] right_calc = isBalancedHelper(right(p));
			boolean right_balanced = (boolean)right_calc[0];
			int h_r = (int)right_calc[1];
			
			int height = Math.max(h_l, h_r) + 1;
			boolean node_balanced = Math.abs(h_l - h_r) <= 1;
			boolean balanced = left_balanced && right_balanced && node_balanced;
			return new Object[] {balanced, height};
		}
	}
		
    public boolean isBalanced() {
    	return (boolean)isBalancedHelper(root)[0];
    }
}
