package ����;

import java.util.Random;
import java.util.Scanner;

public class ���ɰ�����д��ĸСд��ĸ�����ֵ�������� {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int nextInt = scan.nextInt();
		System.out.println(randomPW(nextInt));
		scan.close();
	}
	private static String randomPW(int len) {
		if (len < 3) {
			throw new IllegalArgumentException("���Ȳ���С��3��");
		}

		int lowweCaseNO, higherCaseNo, numberNo;
		Random random = new Random();
		lowweCaseNO = 0;
		while (true) {
			lowweCaseNO = random.nextInt(len) + 1;
			if (lowweCaseNO <= len - 2) {
				break;
			}
		}
		while (true) {
			higherCaseNo = random.nextInt(len - lowweCaseNO) + 1;
			if (higherCaseNo <= len - lowweCaseNO - 1) {
				break;
			}
		}
		numberNo = len - lowweCaseNO - higherCaseNo;

		int select = -1;
		int count = 0;
		StringBuilder stringBuilder = new StringBuilder(len);
		while (count < len) {
			select = random.nextInt(3) + 1;
			switch (select) {
			case 1:// ��д��ĸ
				if (higherCaseNo == 0) {
					continue;
				}
				char selectHigher = (char) (random.nextInt(26) + 'A');
				stringBuilder.append(selectHigher);
				higherCaseNo--;
				count++;
				break;
			case 2:// Сд��ĸ
				if (lowweCaseNO == 0) {
					continue;
				}
				char selectLower = (char) (random.nextInt(26) + 'a');
				stringBuilder.append(selectLower);
				lowweCaseNO--;
				count++;
				break;
			case 3:// ����
				if (numberNo == 0) {
					continue;
				}
				char selectNumber = (char) (random.nextInt(9) + '0');
				stringBuilder.append(selectNumber);
				numberNo--;
				count++;
				break;

			}
		}
		return stringBuilder.toString();
	}
}
