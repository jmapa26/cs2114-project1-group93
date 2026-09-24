import student.TestCase;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

// -------------------------------------------------------------------------
/**
 * Test class for FridgeBuddy
 * 
 * @author Jacob Mapa (jmapa26)
 * @version Sep 24, 2026
 */
public class FridgeBuddyTest extends TestCase {
    // ~ Fields ................................................................
    private FridgeBuddy buddy;
    private ByteArrayOutputStream output;

    // ~Public Methods ........................................................
    /**
     * Set up method
     */
    public void setUp() {
        buddy = new FridgeBuddy();
        output = new ByteArrayOutputStream();
    }


    /**
     * Tests searchFood
     */
    public void testSearchFood() {
    }


    /**
     * Tests displayFood
     */
    public void testDisplayFood() {
    }


    /**
     * Tests addFood
     */
    public void testAddFood() {
    }


    /**
     * Tests removeFood
     */
    public void testRemoveFood() {
    }


    /**
     * Tests printExpiredFood
     */
    public void testPrintExpiredFood() {
    }


    /**
     * Tests readFoodFile
     */
    public void testReadFoodFile() {
    }


    /**
     * Tests writeFoodFile
     */
    public void testWriteFoodFile() {
    }


    /**
     * Tests testIsValidDate
     */
    public void testIsValidDate() {
        assertTrue(buddy.isValidDate("9/24/26")); // normal
        assertFalse(buddy.isValidDate("not a date")); // cannot parse
        assertFalse(buddy.isValidDate("2/30/26")); // invalid date
        assertTrue(buddy.isValidDate("2/29/24")); // leap year date
    }
}
