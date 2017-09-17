package 数据结构;

//树节点类
public class Node<E> {
	public E value;
	public Node<E> left = null;
	public Node<E> right = null;
	
	public Node() {}
	public Node(E value) {
		this.value = value;
	}
}
