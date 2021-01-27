package ttst;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.List;

public class TestsRunner {
	private static void printReport(boolean passed, String class_name) {
		if (passed)
			System.out.println("[ OK ] " + class_name + "\n");
		else
			System.err.println("[ FAILED ] " + class_name + "\n");
	}
	public static void main(String[] args) {
		List<Class> classes = new ArrayList<Class>() {{
			add(AuctionTestUnit.class);
			add(ItemTestUnit.class);
			add(SellerTestUnit.class);
			add(UserTestUnit.class);
		}};

		for (Class testClass : classes) {
			System.out.println("Testing for " + testClass.getSimpleName());
			Result res = JUnitCore.runClasses(testClass);
			for (Failure fail : res.getFailures())
				System.err.println(fail.getTestHeader() + ": " + fail.getMessage());
			printReport(res.wasSuccessful(), testClass.getName());
		}
	}
}
