package ���ݽṹ;
/**
 * ��ģʽƥ��ʱ�临�Ӷȣ�O(mn),m,n�ֱ��ʾ�������ĳ���
 * @author clover
 *
 */
public class �򵥵�ģʽƥ�� {
	public static void main(String[] args) {
		String S = "abcabcaabca";
		String P = "bca";
		
		System.out.println(matchString(S,P));
	}
	//�����±�
	private static int matchString(String s, String p) {
		if(s.length()==0 || p.length()==0) {
			return -1;
		}
		char[] sa = s.toCharArray();
		char[] pa = p.toCharArray();
		
		int index = -1;
		
		for(int i = 0;i<sa.length-pa.length;i++) {
			index = i;//���赱ǰi��ʽģʽƥ�俪ʼ���±�
			for(int j=0;j<pa.length;j++) {
				if(sa[i+j] !=  pa[j]) {
					index = -1;
					break;
				}
			}
			if(index>-1) {// ��ֹ�ҵ���ƥ����±������ȥ��
				return index;
			}
		}
		return index;
	}
}
