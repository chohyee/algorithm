package ���ݽṹ;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<>();//�½�һ���������������
		for(int i=0;i<10;i++) {
			bt.insert(i);
		}
		bt.layerPrint();//��δ�ӡ������
	}
}
