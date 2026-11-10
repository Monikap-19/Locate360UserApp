package hook;

import Base.Baseclass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends Baseclass {
	@Before
	public static void start() throws Exception {
		BrowserLaunch();
	}
	@After
	public static void end() {
		closeApp();
	}
}
