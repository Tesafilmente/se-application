package application.model;

import org.junit.Test;		// JUnit 4

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import application.model.Customer;


/**
 * JUnit tests for Customer class.
 * 
 * @author sgra64
 */
public class CustomerTest {
	final String emptyStr = "";

	private final static String testName_1 = "Marion Koenig";
	private final static String testName_2 = "Erika Schulz";
	private Customer testCustomer_1;
	private Customer testCustomer_2;


	/**
	 * Setup method invoked once before any @Test method is executed.
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println( CustomerTest.class.getSimpleName() + ".setUpBeforeClass() called." );
	}

	/**
	 * Tear-down method invoked once after all @Test methods in this class have finished.
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println( CustomerTest.class.getSimpleName() + ".tearDownAfterClass() called." );
	}

	/**
	 * Setup method executed each time before a @Test method executes.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		testCustomer_1 = new Customer( testName_1 );
		testCustomer_2 = new Customer( testName_2 );
		System.out.println( this.getClass().getSimpleName() + ".setUp() called." );
	}

	/**
	 * Tear-down method invoked each time after a @Test method has finished.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println( this.getClass().getSimpleName() + ".tearDown() called." );
	}


	@Test
	public void testConstructor() {
		final Customer c2 = new Customer( "Larry Hagman" );		// create new Customer object.
		assertTrue( c2.getId() != null );						// Customer id must not be null.
		assertTrue( c2.getId().length() == 7 );					// Customer must be 7-digits.
		assertEquals( "Larry Hagman", c2.getName() );			// Customer name must be the same as in constructor argument.
		assertTrue( c2.getStatus() == Customer.Status.ACT );	// Customer is initially ACTIVE.
	}


	@Test
	public void testSetGetName() {
		assertEquals( testName_1, testCustomer_1.getName() );
		final String testStr = "Meyer";
		testCustomer_1.setName( testStr );
		assertEquals( testStr, testCustomer_1.getName() );
		testCustomer_1.setName( emptyStr );
		assertEquals( emptyStr, testCustomer_1.getName() );
		testCustomer_1.setName( null );
		assertNull( testCustomer_1.getName() );
		testCustomer_1.setName( testName_1 );
	}


	@Test
	public void testSetGetStatus() {
		testCustomer_2.setStatus( Customer.Status.SUSP );
		assertTrue( testCustomer_2.getStatus() == Customer.Status.SUSP );
		testCustomer_2.setStatus( Customer.Status.TERM );
		assertTrue( testCustomer_2.getStatus() == Customer.Status.TERM );
		testCustomer_2.setStatus( Customer.Status.ACT );
		assertTrue( testCustomer_2.getStatus() == Customer.Status.ACT );
	}

}