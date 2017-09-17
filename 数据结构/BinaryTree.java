package ���ݽṹ;

import java.util.LinkedList;

/**
 * ��������(���������)
 * @author clover
 *
 */
public class BinaryTree<E extends Comparable<? super E>> {
	private Node<E> root;//����Ψһ�����ݳ�Ա��ָ���������ͷ���
	
	public BinaryTree(){
		this.root = null;
	}
	
	//..various methods
	public void insert(E value) {
		root = insert(value,root);
	}
	/**
	 * ���ӽڵ㷽��
	 * @param value
	 * @param t
	 * @return
	 */
	private Node<E> insert(E value, Node<E> t) {
		if(t == null) {
			return new Node<E>(value);//tָ��սڵ㣬ֱ�ӽ�value������սڵ㣬���Ҹÿսڵ������������Ϊnull
		}
		int compareResult = value.compareTo(t.value);
		if(compareResult < 0) {//˵���ڵ�Ҫ��������
			t.left = insert(value,t.left);//һ��Ҫ��t.left,��Ȼ�ᵼ������root����ȫ��Ϊnull
		}
		if(compareResult > 0) {//˵���ڵ�Ҫ��������
			t.right = insert(value,t.right);//һ��Ҫ��t.right����Ȼ�ᵼ������root�Һ���ȫ��Ϊnull
		}
		//compareResult == 0 ʲôҲ����
		return t;
	}
	/**
	 * �Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * �Ƿ����value
	 * @param value
	 * @return
	 */
	public boolean contains(E value) {
		return contains(value,root);
	}
	private boolean contains(E value, Node<E> t) {
		if(t == null)return false;
		//ע�ⲻҪֱ��t.value == value����Ϊvalue�������������͡�
		int compareResult = value.compareTo(t.value);
		//β�ݹ�����ױ�while�滻
		if(compareResult < 0) {
			return contains(value,t.left);
		} else if(compareResult > 0) {
			return contains(value,t.right);
		} else return true;
	}
	/**
	 * ������Сֵ
	 * @return
	 */
	public E findMin(){
		if(isEmpty()) throw new RuntimeException();
		return findMin(this.root).value;
	}
	/**
	 * ���ذ�����Сֵ�Ľڵ�
	 * @param t
	 * @return
	 */
	private Node<E> findMin(Node<E> t) {
		if(t == null)return null;
		if(t.left == null) {return t;}
		return findMin(t.left);
	}
	/**
	 * ɾ��ֵΪvalue����
	 * @param value
	 */
	public void remove(E value) {
		root = remove(value,root);
	}
	/**
	 * ɾ��ָ���ڵ㣬���������1.Ҷ�ӡ�2.ֻ��һ���ӽڵ㡢2.�������ӽڵ�
	 * @param value
	 * @param t
	 * @return ���������ڵ�t
	 */
	private Node<E> remove(E value, Node<E> t){
		if(t == null) {return t;}
		int compareResult = value.compareTo(t.value);
		if(compareResult < 0) {
			t.left = remove(value,t.left);
		}else if(compareResult > 0) {
			t.right = remove(value,t.right);
		}else if(t.left!=null && t.right!=null) {//˵������Ҫɾ����ǰ�ڵ㣬Ҫ��������� 1.���ڵ�ΪҶ�ӽڵ� 
										//2.��ֻ��һ������
										//3.���ڵ�����������
			t.value = findMin(t.right).value;//������������СԪ�ش��浱ǰԪ����
			t.right = remove(t.value,t.right);//Ȼ��ɾ����ǰ�ڵ���������ֵΪvalue�Ľڵ�
		}else {
			t = (t.left != null)? t.left:t.right;//t.left != null ˵�� t.right == null;����t.left == null;
		}
		return t;
	}
	/**
	 * ��α�������������
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
