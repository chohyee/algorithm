package 数据结构;

import java.util.Scanner;
import java.util.Stack;

public class 中缀表达式转后缀表达式 {
	public static void main(String[] args) {
		//假设已经通过正则表达式匹配过了输入
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		//如果运算符繁多，可以设置一个运算符优先级kv容器
		String ss = preTobeh(str);
		System.out.println(ss);
		scan.close();
	}
	/**
	 * 	前缀转后缀表达式(小写字母和数字和加减乘运算、括号等)
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
				sb.append(arr[i]);//操作数直接输出到StringBuilder中
			}else {
				//如果此时栈空
				if(stack.isEmpty()) {
					stack.push(arr[i]);
				}else {//栈不为空
					if(arr[i] == ')') {
						while(!stack.isEmpty()&&stack.peek() != '(') {
							sb.append(stack.pop());
						}
						if(!stack.isEmpty()) {
							stack.pop();//去掉'('
						}
					}else if(arr[i] == '(' || stack.peek() == '(' ){//直接往栈里放即可
						stack.push(arr[i]);
					}else if(arr[i] < stack.peek()){//arr[i]优先级高的
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
