package 数据结构;

import java.util.LinkedList;

/**
 * 二叉树类(排序二叉树)
 * @author clover
 *
 */
public class BinaryTree<E extends Comparable<? super E>> {
	private Node<E> root;//包含唯一的数据成员，指向二叉链表头结点
	
	public BinaryTree(){
		this.root = null;
	}
	
	//..various methods
	public void insert(E value) {
		root = insert(value,root);
	}
	/**
	 * 增加节点方法
	 * @param value
	 * @param t
	 * @return
	 */
	private Node<E> insert(E value, Node<E> t) {
		if(t == null) {
			return new Node<E>(value);//t指向空节点，直接将value给这个空节点，并且该空节点的左右子树均为null
		}
		int compareResult = value.compareTo(t.value);
		if(compareResult < 0) {//说明节点要放左子树
			t.left = insert(value,t.left);//一定要加t.left,不然会导致树的root左孩子全部为null
		}
		if(compareResult > 0) {//说明节点要放右子树
			t.right = insert(value,t.right);//一定要加t.right，不然会导致树的root右孩子全部为null
		}
		//compareResult == 0 什么也不做
		return t;
	}
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * 是否包含value
	 * @param value
	 * @return
	 */
	public boolean contains(E value) {
		return contains(value,root);
	}
	private boolean contains(E value, Node<E> t) {
		if(t == null)return false;
		//注意不要直接t.value == value，因为value可能是引用类型。
		int compareResult = value.compareTo(t.value);
		//尾递归很容易被while替换
		if(compareResult < 0) {
			return contains(value,t.left);
		} else if(compareResult > 0) {
			return contains(value,t.right);
		} else return true;
	}
	/**
	 * 返回最小值
	 * @return
	 */
	public E findMin(){
		if(isEmpty()) throw new RuntimeException();
		return findMin(this.root).value;
	}
	/**
	 * 返回包含最小值的节点
	 * @param t
	 * @return
	 */
	private Node<E> findMin(Node<E> t) {
		if(t == null)return null;
		if(t.left == null) {return t;}
		return findMin(t.left);
	}
	/**
	 * 删除值为value的项
	 * @param value
	 */
	public void remove(E value) {
		root = remove(value,root);
	}
	/**
	 * 删除指定节点，三种情况，1.叶子、2.只有一个子节点、2.有两个子节点
	 * @param value
	 * @param t
	 * @return 返回树根节点t
	 */
	private Node<E> remove(E value, Node<E> t){
		if(t == null) {return t;}
		int compareResult = value.compareTo(t.value);
		if(compareResult < 0) {
			t.left = remove(value,t.left);
		}else if(compareResult > 0) {
			t.right = remove(value,t.right);
		}else if(t.left!=null && t.right!=null) {//说明就是要删除当前节点，要分三种情况 1.本节点为叶子节点 
										//2.本只有一个儿子
										//3.本节点有两个儿子
			t.value = findMin(t.right).value;//用右子树的最小元素代替当前元素域
			t.right = remove(t.value,t.right);//然后删除当前节点右子树下值为value的节点
		}else {
			t = (t.left != null)? t.left:t.right;//t.left != null 说明 t.right == null;否则t.left == null;
		}
		return t;
	}
	/**
	 * 层次遍历二叉搜索树
	 */
	public void layerPrint() {
		layerPrint(root);
	}
	private void layerPrint(Node<E> t) {
		LinkedList<Node<E>> list = new LinkedList<>();
		list.offer(t);
		
		while(list.size()>0) {
			Node<E> temp = list.pop();
			if(temp.left!=null) {
				list.offer(temp.left);
			}
			if(temp.right!=null) {
				list.offer(temp.right);
			}
			System.out.println(temp.value);
		}
	}
}
