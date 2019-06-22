package timer;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class MethodsTimer {
	private static final int MAXIMUM_SIZE = 1000;
	public static final long ONE_SECOND = 1000000000;
	private final Method[] methods;
	
	public MethodsTimer(Method[] methods) {
		this.methods = methods;
		sortMethodByName();
		showClassName(methods);
	}
	
	private void sortMethodByName() {
		MethodComparator comparator = new MethodComparator();
		Arrays.sort(this.methods, comparator);
	}
	
	class MethodComparator implements Comparator<Method>{
		@Override
		public int compare(Method method1, Method method2) {
			String name1 = method1.getName();
			String name2 = method2.getName();
			return name1.compareTo(name2);
		}
	}

	private void showClassName(Method[] methods) {
		Method firstMethod = methods[0];
		Class<?> firstClass = firstMethod.getDeclaringClass();
		System.out.println(firstClass.getName());
	}

	public void report() throws Exception {
		for (Method method : methods) {
			System.out.print(method.getName() + "\t");
			for (int size = 1 ; size <= MAXIMUM_SIZE ; size *= 10) {
				MethodTimer r = new MethodTimer(size, method);
				r.run();
				System.out.print(String.format("%.2f\t", r.getMethodTime()));
			}
			System.out.println();
		}
		
	}
}
