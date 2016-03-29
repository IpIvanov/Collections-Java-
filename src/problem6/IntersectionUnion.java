package problem6;

import java.util.ArrayList;

public class IntersectionUnion {

	// ������ �� ��� ������ �� �����, ���������� ���� ���������:
	// - f1(0) = 1; f1(k) = 2*f1(k-1) + 3; f1 = {1, 5, 13, 29, �}
	// - f2(0) = 2; f2(k) = 3*f2(k-1) + 1; f2 = {2, 7, 22, 67, �}
	// - f3(0) = 2; f3(k) = 2*f3(k-1) - 1; f3 = {2, 3, 5, 9, �}
	// �������� ��������, ����� ������ ��������� � ������������ �� �����������
	// �� ��������� �� �������� � ��������� [0; 100000]: f1 * f2; f1 * f3; f2 *
	// f3; f1 * f2 * f3; f1 + f2; f1 + f3; f2 + f3; f1 + f2 + f3. ��� ���������
	// + � * ���������� ��������� ���������� � ������� �� ���������.

	public static void main(String[] args) {
		System.out.println(multipleInts());

	}

	private static ArrayList<Integer> multipleInts() {
		int element;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i <= 1000; i++) {
			element = addElement(i);
			arrayList.add(element);
		}
		return arrayList;
	}

	private static int addElement(int i) {
		int number = 2 * i + 3;
		return number;
	}

}
