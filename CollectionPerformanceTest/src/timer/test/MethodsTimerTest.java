package timer.test;

//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.Lists;
import data.Maps;
import data.SetVsArrayList;
import timer.MethodsTimer;

class MethodsTimerTest {

	@Test
	void testSetVsArrayPerformance() throws Exception {
		MethodsTimer tester = new MethodsTimer(SetVsArrayList.class.getDeclaredMethods());
		tester.report();
	}
	
	@Test
	void testListPerformance() throws Exception {
		MethodsTimer tester = new MethodsTimer(Lists.class.getDeclaredMethods());
		tester.report();
	}

	@Test
	void testMapPerformance() throws Exception {
		MethodsTimer tester = new MethodsTimer(Maps.class.getDeclaredMethods());
		tester.report();
	}
}
