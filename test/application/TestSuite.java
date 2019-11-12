package application;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import application.model.CustomerTest;


/**
 * JUnit TestSuite.
 * 
 * @author sgra64
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	CustomerTest.class,
})
public class TestSuite {

	/**
	 * Setup method invoked before test classes in test suite are executed.
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println( TestSuite.class.getSimpleName() + ".setUpBeforeClass() called." );
	}

	/**
	 * Tear-down method invoked after test classes in test suite have finished.
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println( TestSuite.class.getSimpleName() + ".tearDownAfterClass() called." );
	}

}
