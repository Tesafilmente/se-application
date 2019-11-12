package application.model;
import org.junit.Test;		// JUnit 4

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.lang.Object;

public class ArticleTest {
	
	final String emptyStr = "";
	
	private String testName_1 = "MyFunny Name 123";
    private String testName_2 = "MyFunny-!Nameljrkgörglk 123";

    private Article testArticle1;
    private Article testArticle2;

	


	/**
     * Setup method invoked once before any @Test method is executed.
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println(ArticleTest.class.getSimpleName() + ".setUpBeforeClass() called.");
    }

    /**
     * Tear-down method invoked once after all @Test methods in this class have finished.
     *
     * @throws Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println(ArticleTest.class.getSimpleName() + ".tearDownAfterClass() called.");
    }
		
    
    /**
     * Setup method executed each time before a @Test method executes.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
    	testArticle1 = new Article("Kugelschreiber", "123 €");
        testArticle2 = new Article("Buch", "999 €");
        System.out.println(this.getClass().getSimpleName() + ".setUp() called.");
    }
	
    /**
     * Tear-down method invoked each time after a @Test method has finished.
     *
     * @throws Exception
     */
	@After
	public void tearDown() throws Exception {
		System.out.println( this.getClass().getSimpleName() + ".tearDown() called." );
	}
	
	@Test
    public void testConstructor() {
		final Article a = new Article("MyFunnyName", "12345 ABC");


		assertNotNull(a.getId());
        assertEquals(9, a.getId().length());
        assertEquals('P', a.getId().charAt(0));
        assertFalse("Die ID darf keine Leerzeichen enthalten.", a.getId().contains(" "));
        assertFalse("Die ID darf keine Tabs enthalten.", a.getId().contains("\t"));
        assertFalse("Die ID darf keinen Zeilenumbrüche enthalten.", a.getId().contains("\n"));
        assertFalse("Die ID darf keinen Zeilenumbrüche enthalten.", a.getId().contains("\r"));

        String idNumericPart = a.getId().substring(1);

        int idNumeric = 0;
        

        try {
            idNumeric = Integer.parseInt(idNumericPart);
        } catch (Exception e) {
            fail("Die ID muss numerisch sein.");
        }

        assertTrue(idNumeric != 0);
        
        
        assertEquals("MyFunnyName", a.getName());
        assertEquals("12345 ABC", a.getPrice());
    }
	

    @Test
    public void testSetGetName() {
        String testStr = "SD Card 64GB";
        testArticle1.setName(testStr);
        assertEquals(testStr, testArticle1.getName());

        testStr = "**Ä B C **";
        testArticle1.setName(testStr);
        assertEquals(testStr, testArticle1.getName());

        testStr = "  \t   \t \n\t";
        testArticle1.setName(testStr);
        assertEquals(testStr, testArticle1.getName());

        testArticle1.setName(null);
        assertNull(testArticle1.getName());

        testArticle1.setName(testName_1);
    }


    @Test
    public void testSetGetPrice() {
        String testStr = "SD Card 64GB";
        testArticle1.setPrice(testStr);
        assertEquals(testStr, testArticle1.getPrice());

        testStr = "**Ä B C **";
        testArticle1.setPrice(testStr);
        assertEquals(testStr, testArticle1.getPrice());

        testStr = "  \t   \t \n\t";
        testArticle1.setPrice(testStr);
        assertEquals(testStr, testArticle1.getPrice());

        testArticle1.setPrice(null);
        assertNull(testArticle1.getPrice());

        testStr = "-9,99 EUR";
        testArticle1.setPrice(testStr);
        assertEquals("0,00 EUR", testArticle1.getPrice());
    }
}
