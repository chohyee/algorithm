package 数据结构;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<>();//新建一个排序二叉树对象
		for(int i=0;i<10;i++) {
			bt.insert(i);
		}
		bt.layerPrint();//层次打印二叉树
	}
}
