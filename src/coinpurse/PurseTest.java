package coinpurse;
 

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Purse.
 * This is a JUnit 4 test.  
 * To run these tests, right click on this file (in Navigator pane)
 * and choose Run As -> JUnit test
 * @author  Resident Evil
 * @version 2017.02.01
 */
public class PurseTest {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /** Easy test that the Purse constructor is working. */
    @Test
    public void testConstructor()
    {
        Purse purse = new Purse(3);
        assertEquals(3, purse.getCapacity());
        assertEquals(false, purse.isFull());
        assertEquals(0, purse.count());
    }

    

    /** Insert some coins. Easy test. */
    @Test
    public void testInsert()
    {
        Purse purse = new Purse(3);
        Coin coin1 = new Coin(5);
        Coin coin2 = new Coin(10);
        Coin coin3 = new Coin(1);
        assertTrue( purse.insert(coin1));
        assertTrue( purse.insert(coin3));
        assertTrue( purse.insert(coin2));
        assertEquals( 3, purse.count() );
        // purse is full so insert should fail
        assertFalse( purse.insert(new Coin(1)) );
    }
    

    /** Insert should reject coin with no value. */
    @Test
    public void testInsertNoValue()
    {
        Purse purse = new Purse(3);
        Coin fakeCoin = new Coin(0);
        assertFalse( purse.insert(fakeCoin));
    }


    @Test
    public void testIsFull()
    {   // borderline case (capacity 1)
        Purse purse = new Purse(1);
        assertFalse( purse.isFull() );
        purse.insert( new Coin(1) );
        assertTrue( purse.isFull() );
        // real test
        int capacity = 4;
        purse = new Purse(capacity);
        for(int k=1; k<=capacity; k++) {
            assertFalse(purse.isFull());
            purse.insert( new Coin(k) );
        }
        // full now
        assertTrue( purse.isFull() );
        assertFalse( purse.insert( new Coin(5) ) );
    }

	/** Should be able to insert same coin many times,
	 *  since spec doesn't say anything about this.
	 */
	@Test
	public void testInsertSameCoin()
	{
		Purse purse = new Purse(5);
		Coin coin = new Coin(10);
		assertTrue( purse.insert(coin) );
		assertTrue( purse.insert(coin) ); // should be allowed
		assertTrue( purse.insert(coin) ); // should be allowed
	}

	@Test
	public void testEasyWithdraw() {
		Purse purse = new Purse(10);
		int [] values = {1, 10, 1000};
		for(int value : values) {
			Coin coin = new Coin(value);
			assertTrue(purse.insert(coin));
			assertEquals(value,  purse.getBalance(), TOL);
			Coin [] result = purse.withdraw(value);
			assertTrue( result != null );
			assertEquals( 1, result.length );
			assertSame(  coin, result[0] );
			assertEquals( 0, purse.getBalance(), TOL );
		}
	}
	

	@Test
	public void testWithdrawTwoCoins() {
		Purse purse = new Purse(10);
		double value1 = 5;
		double value2 = 10;
		purse.insert(new Coin(value1));
		purse.insert(new Coin(value2));
		
		// withdraw 2nd coin
		Coin [] result = purse.withdraw(value2);
		assertTrue( result != null );
		assertEquals( 1, result.length );
		assertEquals(  value2, result[0].getValue(), TOL );
		assertEquals( value1, purse.getBalance(), TOL );
		
		result = purse.withdraw(value1);
		assertTrue( result != null );
		assertEquals( 1, result.length );
		assertEquals(  value1, result[0].getValue(), TOL );
		assertEquals( 0.0, purse.getBalance(), TOL );
	}

	@Test
	public void testMultiWithdraw() {
		Purse purse = new Purse(10);
		int value = 1;
		double amount1 = 0;
		double amount2 = 0;
		for(int k=1; k<10; k=k+2)  {
			assertTrue( purse.insert( new Coin(value)) );
			amount1 += value;
			value = 2*value;
			assertTrue( purse.insert( new Coin(value)) );
			amount2 += value;
			value = 2*value;
		}
		assertEquals(amount1+amount2, purse.getBalance(), TOL );
		assertEquals(10, purse.count() );
		Coin [] wd1 = purse.withdraw(amount1);
		assertEquals(amount1, sumValue(wd1), TOL );
		assertEquals(amount2, purse.getBalance(), TOL );
		Coin [] wd2 = purse.withdraw(amount2);
		assertEquals(0, purse.getBalance(), TOL );
	}
	

	@Test
	public void testMultiWithdraw2() {
		int [] values = { 1, 40, 5, 20, 10, 80 };
		double amount1 = 16; // first amount to withdraw
		double amount2 = 140; // second amount to withdraw
		
		Purse purse = new Purse(10);
		for(int value : values ) assertTrue( purse.insert(new Coin(value)) );
		// check the balance
		assertEquals(amount1+amount2, purse.getBalance(), TOL );

		// test first withdraw and balance remaining
		Coin [] wd1 = purse.withdraw(amount1);
		assertEquals(amount1, sumValue(wd1), TOL );
		//assertEquals(amount2, purse.getBalance(), TOL );
		
		Coin [] wd2 = purse.withdraw(amount2);
		// did we get correct amount?
		assertNotNull( "Withdraw didn't succeed.", wd2 );
		// test the total withdrawn
		assertEquals(amount2, sumValue(wd2), TOL);
		assertEquals(0, purse.getBalance(), TOL );
	}

	@Test
	public void testImpossibleWithdraw() {
		Purse purse = new Purse(10);
		assertNull( purse.withdraw(1) );
		purse.insert( new Coin(20) );
		assertNull( purse.withdraw(1) );
		assertNull( purse.withdraw(19) );
		assertNull( purse.withdraw(21) );
		purse.insert( new Coin(20) );
		assertNull( purse.withdraw(30) );
	}
	
	/**
	 * Sum the value of some coins.
	 * @param coins array of coins
	 * @return sum of values of the coins
	 */
	private double sumValue(Coin [] coins)  {
		if (coins == null) return 0;
		double sum = 0;
		for(Coin c: coins) if (c != null) sum += c.getValue();
		return sum;
	}
}

