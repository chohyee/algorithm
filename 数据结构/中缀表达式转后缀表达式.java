package ���ݽṹ;

import java.util.Scanner;
import java.util.Stack;

public class ��׺���ʽת��׺���ʽ {
	public static void main(String[] args) {
		//�����Ѿ�ͨ��������ʽƥ���������
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		//�����������࣬��������һ����������ȼ�kv����
		String ss = preTobeh(str);
		System.out.println(ss);
		scan.close();
	}
	/**
	 * 	ǰ׺ת��׺���ʽ(Сд��ĸ�����ֺͼӼ������㡢���ŵ�)
	 * @param str
	 */
	private static String preTobeh(String str) {
		if(str == null || str.length() == 0) {return str;}
		
		char[] arr = str.toCharArray();
		int i = 0;
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		while(i<arr.length) {
			if(arr[i]>='0'&&arr[i]<='9' || arr[i]>='a'&&arr[i]<='z') {
				sb.append(arr[i]);//������ֱ�������StringBuilder��
			}else {
				//�����ʱջ��
				if(stack.isEmpty()) {
					stack.push(arr[i]);
				}else {//ջ��Ϊ��
					if(arr[i] == ')') {
						while(!stack.isEmpty()&&stack.peek() != '(') {
							sb.append(stack.pop());
						}
						if(!stack.isEmpty()) {
							stack.pop();//ȥ��'('
						}
					}else if(arr[i] == '(' || stack.peek() == '(' ){//ֱ����ջ��ż���
						stack.push(arr[i]);
					}else if(arr[i] < stack.peek()){//arr[i]���ȼ��ߵ�
						stack.push(arr[i]);
					}else {
						while(!stack.isEmpty() && stack.peek() != '(' &&stack.peek() <= arr[i]) {
							sb.append(stack.pop());
						}
						stack.push(arr[i]);
					}
				}
			
			}
			i++;
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
}
