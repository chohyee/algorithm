package 数据结构;

public class 模式匹配的KMP算法 {
	public static void main(String[] args) {
		String s = "abcabcaabca";
		String p = "bca";
		System.out.println(matchString(s,p));
		
	}
	private static int matchString(String s, String p) {
		int[] fail = new int[p.length()];//失败函数值,f[j]表示j+1处失配，则j回溯到f[j]
		failMethod(p,fail);
		
		char[] sa = s.toCharArray();
		char[] pa = p.toCharArray();
	
		int m = sa.length;
		int n = pa.length;
		
		int i=0,j=0;
		while(i<=m-n) {
			if(sa[i] == pa[j]) {
				if(j==n-1) {//判断是不是找到了匹配的
					return i-(n-1);
				}else {
					i++;
					j++;
				}
			}else if(j>0) {
				j=fail[j-1];//失败函数值,f[j]表示j+1处失配，则j回溯到f[j],即在j处失配则j回溯到f[j-1]处
			}else {
				i++;
			}
		}
		
		return -1;
	}
	//失败函数，仅与p有关
	private static void failMethod(String p, int[] f) {
		f[0] = 0;
		int j = 1; 
		int k = 0;
		char[] pa = p.toCharArray();
		while(j<pa.length) {
			if(pa[j] == pa[k]) {
				f[j] = k+1;
				j++;
				k++;
			}else if(k>0){
				k = f[k-1];//主要搞明白k回溯至哪里
			}else {
				f[j] = 0;
				j++;
			}
		}
	}
}
