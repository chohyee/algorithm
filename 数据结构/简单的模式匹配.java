package 数据结构;
/**
 * 简单模式匹配时间复杂度：O(mn),m,n分别表示两个串的长度
 * @author clover
 *
 */
public class 简单的模式匹配 {
	public static void main(String[] args) {
		String S = "abcabcaabca";
		String P = "bca";
		
		System.out.println(matchString(S,P));
	}
	//返回下标
	private static int matchString(String s, String p) {
		if(s.length()==0 || p.length()==0) {
			return -1;
		}
		char[] sa = s.toCharArray();
		char[] pa = p.toCharArray();
		
		int index = -1;
		
		for(int i = 0;i<sa.length-pa.length;i++) {
			index = i;//假设当前i正式模式匹配开始的下标
			for(int j=0;j<pa.length;j++) {
				if(sa[i+j] !=  pa[j]) {
					index = -1;
					break;
				}
			}
			if(index>-1) {// 防止找到了匹配的下标而跳过去了
				return index;
			}
		}
		return index;
	}
}
