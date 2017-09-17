package ���ݽṹ;

public class ģʽƥ���KMP�㷨 {
	public static void main(String[] args) {
		String s = "abcabcaabca";
		String p = "bca";
		System.out.println(matchString(s,p));
		
	}
	private static int matchString(String s, String p) {
		int[] fail = new int[p.length()];//ʧ�ܺ���ֵ,f[j]��ʾj+1��ʧ�䣬��j���ݵ�f[j]
		failMethod(p,fail);
		
		char[] sa = s.toCharArray();
		char[] pa = p.toCharArray();
	
		int m = sa.length;
		int n = pa.length;
		
		int i=0,j=0;
		while(i<=m-n) {
			if(sa[i] == pa[j]) {
				if(j==n-1) {//�ж��ǲ����ҵ���ƥ���
					return i-(n-1);
				}else {
					i++;
					j++;
				}
			}else if(j>0) {
				j=fail[j-1];//ʧ�ܺ���ֵ,f[j]��ʾj+1��ʧ�䣬��j���ݵ�f[j],����j��ʧ����j���ݵ�f[j-1]��
			}else {
				i++;
			}
		}
		
		return -1;
	}
	//ʧ�ܺ���������p�й�
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
				k = f[k-1];//��Ҫ������k����������
			}else {
				f[j] = 0;
				j++;
			}
		}
	}
}
