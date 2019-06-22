package timer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MethodTimer {
	private final int size;
	private final Method method;
	private Object instance;
	private long totalTime;
	private int iterations;
	private long overhead;

	public MethodTimer(int size, Method method) throws Exception {
		this.size = size;
		this.method = method;
		instance = createInstance();
	}
	
	private Object createInstance() throws Exception {
		Constructor<?> constructor = method.getDeclaringClass()
				.getConstructor(new Class[] {int.class});
		return constructor.newInstance(new Object[] {size});
	}
	
	public MethodTimer() throws Exception {
		this(0, MethodTimer.Overhead.class.getMethod("nothing"));
	}
	
	public static class Overhead {
		public Overhead(int size) {
			
		}
		
		public void nothing() {
			
		}
	}

	public void run() throws Exception {
		MethodTimer overheadTimer = new MethodTimer();
		do {
			iterations++;
			totalTime += computeTotalTime();
			overhead += overheadTimer.computeTotalTime();
		}while (totalTime < MethodsTimer.ONE_SECOND);		
	}

	private long computeTotalTime() throws Exception {
		long start = System.nanoTime();
		method.invoke(instance);
		long end = System.nanoTime();
		long computeNs = end-start;
		return computeNs;
	}

	public Object getMethodTime() {
		return (double)(totalTime-overhead)/(double)iterations;
	}
}
