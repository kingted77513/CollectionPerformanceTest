package timer.test;

//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.SetVsArrayList;
import timer.MethodsTimer;

class MethodsTimerTest {

	@Test
	void testReport() throws Exception {
		MethodsTimer tester = new MethodsTimer(SetVsArrayList.class.getDeclaredMethods());
		tester.report();
	}

}
