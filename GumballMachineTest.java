

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GumballMachineTest
{
    private GumballMachine m1;

    /**
     * Default constructor for test class GumballMachineTest
     */
    public GumballMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        m1 = new GumballMachine(5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void Testwith25cents()
    {
        System.out.println("\n***Test 1: Testwith25cents***");
        m1.insertCoin(25);
        m1.turnCrank();
        assertEquals(true, m1.hasgumball());
    }

    @Test
    public void Testwithlessthan25cents()
    {
        System.out.println("\n***Test 2: Testwithlessthan25cents***");
        m1.insertCoin(5);
        m1.insertCoin(10);
        m1.turnCrank();
        assertEquals(false, m1.hasgumball());
    }

    @Test
    public void Testwithnocents()
    {
        System.out.println("\n***Test 3: Testwithnocents***");
        m1.turnCrank();
        assertEquals(false, m1.hasgumball());
    }

    @Test
    public void testwith_morethan25_lessthan50cents()
    {
        System.out.println("\n***Test 4: testwith_morethan25_lessthan50cents***");
        m1.insertCoin(5);
        m1.insertCoin(25);
        m1.insertCoin(10);
        m1.turnCrank();
        assertEquals(false, m1.hasgumball());
    }

    @Test
    public void testwith50cents()
    {
        System.out.println("\n***Test 5: testwith50cents***");
        m1.insertCoin(25);
        m1.insertCoin(25);
        m1.turnCrank();
        assertEquals(true, m1.hasgumball());
    }

    @Test
    public void testwith50cents_diffcoins()
    {
        System.out.println("\n***Test 6: testwith50cents_diffcoins***");
        m1.insertCoin(5);
        m1.insertCoin(10);
        m1.insertCoin(5);
        m1.insertCoin(5);
        m1.insertCoin(25);
        m1.turnCrank();
        assertEquals(true, m1.hasgumball());
    }

    @Test
    public void testwithmorethan50cents()
    {
        System.out.println("\n***Test 7: testwithmorethan50cents***");
        m1.insertCoin(25);
        m1.insertCoin(25);
        m1.insertCoin(5);
        m1.insertCoin(10);
        m1.turnCrank();
        assertEquals(true, m1.hasgumball());
    }

    @Test
    public void Testwith25cents_withdimesndnickels()
    {
        System.out.println("\n***Test 8: Testwith25cents_withdimesndnickels***");
        m1.insertCoin(10);
        m1.insertCoin(10);
        m1.insertCoin(5);
        m1.turnCrank();
        assertEquals(false, m1.hasgumball());
    }
}








