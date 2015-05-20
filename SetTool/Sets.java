package SetTool;

/**
 * set ���ߣ�����set�ĺϲ����������Լ���ȡ����֮�������Ԫ�ص�set,�ͻ�ȡ�Ƴ�����һ��set������Ԫ�ص�set
 * @author BAO
 */

import java.util.*;
public class Sets {

	/**
	 * ����һ���ϲ����set
	 */
	public static <T> Set<T> union(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}

	/**
	 * ����һ��������set
	 */
	public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}
	
	/**
	 * ����һ����subSet��Ԫ��֮�����е�superSetԪ�ص�set
	 */
	public static <T> Set<T> difference(Set<T> superSet, Set<T> subSet) {
		Set<T> result = new HashSet<T>(superSet);
		result.removeAll(subSet);
		return result;
	}
	
	/**
	 * ����2��set�г��˽���֮�������Ԫ������ɵ�set
	 */
	public static <T> Set<T> complement(Set<T> a, Set<T> b) {
		return difference(union(a,b), intersection(a, b));
	}
	
	public static void main(String[] args) {
		Set<String> a = new HashSet<String>(Arrays.asList("a","b","c"));
		Set<String> b = new HashSet<String>(Arrays.asList("b","d","e"));
		System.out.println(union(a, b));
		System.out.println(intersection(a, b));
		System.out.println(difference(a, b));
		System.out.println(complement(a, b));
	}
}
