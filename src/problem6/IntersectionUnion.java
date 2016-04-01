package problem6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class IntersectionUnion {

	// Дадени са три редици от числа, дефинирани чрез формулите:
	// - f1(0) = 1; f1(k) = 2*f1(k-1) + 3; f1 = {1, 5, 13, 29, …}
	// - f2(0) = 2; f2(k) = 3*f2(k-1) + 1; f2 = {2, 7, 22, 67, …}
	// - f3(0) = 2; f3(k) = 2*f3(k-1) - 1; f3 = {2, 3, 5, 9, …}
	// Напишете програма, която намира сечението и обединението на множе­ствата
	// от членовете на редиците в интервала [0; 100000]: f1 * f2; f1 * f3; f2 *
	// f3; f1 * f2 * f3; f1 + f2; f1 + f3; f2 + f3; f1 + f2 + f3. Със символите
	// + и * означаваме съответно обединение и сечение на множества.

	public static void main(String[] args) {
		System.out.println(f1());
		System.out.println(f2());
		System.out.println(f3());
		Set<Integer> f1Set = new HashSet<>(f1());
		Set<Integer> f2Set = new HashSet<>(f2());
		Set<Integer> f3Set = new HashSet<>(f3());
		System.out.println(unionTwoSets(f1Set, f2Set));
		System.out.println(unionTwoSets(f1Set, f3Set));
		System.out.println(unionTwoSets(f2Set, f3Set));
		System.out.println(unionThreeSets(f1Set, f2Set, f3Set));
		System.out.println(intersectTwoSets(f1Set, f2Set));
		System.out.println(intersectTwoSets(f1Set, f3Set));
		System.out.println(intersectTwoSets(f2Set, f3Set));
		System.out.println(intersectThreeSets(f1Set, f2Set, f3Set));

	}

	private static ArrayList<Integer> f1() {
		int element;
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		for (int i = 1; i <= 15; i++) {
			element = 2 * arrayList.get(i - 1) + 3;
			arrayList.add(element);
		}
		return arrayList;
	}

	private static ArrayList<Integer> f2() {
		int element;
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(2);
		for (int i = 1; i <= 15; i++) {
			element = 3 * arrayList.get(i - 1) + 1;
			arrayList.add(element);

		}
		return arrayList;
	}

	private static ArrayList<Integer> f3() {
		int element;
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(2);
		for (int i = 1; i <= 15; i++) {
			element = 2 * arrayList.get(i - 1) - 1;
			arrayList.add(element);
		}
		return arrayList;
	}

	private static <E> Set<E> unionTwoSets(Set<E> set1, Set<E> set2) {
		Set<E> union = new HashSet<E>();
		union.addAll(set1);
		union.addAll(set2);
		return new TreeSet<E>(union);
	}

	private static <E> Set<E> unionThreeSets(Set<E> set1, Set<E> set2, Set<E> set3) {
		Set<E> union = new HashSet<E>();
		union.addAll(set1);
		union.addAll(set2);
		union.addAll(set3);
		return new TreeSet<E>(union);
	}

	private static <E> Set<E> intersectTwoSets(Set<E> set1, Set<E> set2) {
		Set<E> intersect = new HashSet<E>();
		intersect.addAll(set1);
		intersect.retainAll(set2);
		return new TreeSet<E>(intersect);
	}

	private static <E> Set<E> intersectThreeSets(Set<E> set1, Set<E> set2, Set<E> set3) {
		Set<E> intersect = new HashSet<E>();
		intersect.addAll(set1);
		intersect.retainAll(set2);
		intersect.retainAll(set3);
		return new TreeSet<E>(intersect);
	}
}
