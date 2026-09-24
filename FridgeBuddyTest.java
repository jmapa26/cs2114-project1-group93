import student.TestCase;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.lang.reflect.Field;

// Methods generated with the help of LLM.

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
     * Set up method, empty for now.
     */
    public void setUp() {
        buddy = new FridgeBuddy();
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }


    /**
     * Tests searchFood
     * 
     * @exception Exception
     */
    public void testSearchFood() throws Exception {
        provideInput("Apple\n" + "10/1/26\n" + "Red apple\n");
        buddy.addFood();

        provideInput("Apple\n");
        buddy.searchFood();
        String result = output.toString();

        assertTrue(result.contains("Apple"));
        assertTrue(result.contains("10/1/26"));
        assertTrue(result.contains("Red apple"));
    }


    /**
     * Tests displayFood
     * 
     * @exception Exception
     */
    public void testDisplayFood() throws Exception {
        provideInput("Apple\n" + "10/1/26\n" + "Red apple\n");

        buddy.addFood();

        output.reset();

        buddy.displayFood();

        String result = output.toString();

        assertTrue(result.contains("Here are all the Foods:"));
        assertTrue(result.contains("Apple"));
        assertTrue(result.contains("Red apple"));
        assertTrue(result.contains("10/1/26"));
    }


    /**
     * Tests addFood
     * 
     * @exception Exception
     */
    public void testAddFood() throws Exception {
        provideInput("Apple\n" + "10/1/26\n" + "Red apple\n");

        buddy.addFood();

        // We can verify that the food was added by calling
        // displayFood() and checking its output.
        buddy.displayFood();

        String result = output.toString();

        assertTrue(result.contains("Apple"));
        assertTrue(result.contains("10/1/26"));
        assertTrue(result.contains("Red apple"));
    }


    /**
     * Tests removeFood
     * 
     * @exception Exception
     */
    public void testRemoveFood() throws Exception {
        provideInput("Apple\n" + "10/1/26\n" + "Red apple\n");
        buddy.addFood();

        provideInput("Apple\n");
        buddy.removeFood();

        assertTrue(output.toString().contains("You have removed: Apple"));
    }


    /**
     * Tests printExpiredFood
     * 
     * @throws Exception
     */
    public void testPrintExpiredFood() throws Exception {
        provideInput("Old Milk\n" + "1/1/20\n" + "Expired milk\n");

        buddy.addFood();

        output.reset();

        buddy.printExpiredFood();

        String result = output.toString();

        assertTrue(result.contains("Here are all the Expired Foods"));
        assertTrue(result.contains("Old Milk"));
        assertTrue(result.contains("Expired milk"));
    }


    /**
     * Tests readFoodFile
     * 
     * @exception Exception
     */
    public void testReadFoodFile() throws Exception {
        buddy.readFoodFile();

        // We can verify what was read by displaying the foods.
        buddy.displayFood();

        String result = output.toString();

        // Replace these with values that exist in your test CSV file.
        assertTrue(result.contains("Apple"));
    }


    /**
     * Tests writeFoodFile
     * 
     * @exception Exception
     */
    public void testWriteFoodFile() throws Exception {
        provideInput("Apple\n" + "10/1/26\n" + "Red apple\n");

        buddy.addFood();

        buddy.writeFoodFile();

        // Create a new FridgeBuddy and read the file that was written.
        FridgeBuddy secondBuddy = new FridgeBuddy();

        secondBuddy.readFoodFile();

        output.reset();

        secondBuddy.displayFood();

        String result = output.toString();

        assertTrue(result.contains("Apple"));
        assertTrue(result.contains("10/1/26"));
        assertTrue(result.contains("Red apple"));
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


    // ~ Helper Methods ........................................................
    /**
     * Supplies simulated keyboard input to the FridgeBuddy scanner.
     *
     * @param input
     *            the simulated user input
     */
    private void provideInput(String input) throws Exception {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Field scannerField = FridgeBuddy.class.getDeclaredField("scanner");

        scannerField.setAccessible(true);

        scannerField.set(buddy, new Scanner(System.in));
    }


    /**
     * Gets the private Fridge object from FridgeBuddy.
     *
     * @return the Fridge belonging to the FridgeBuddy
     */
    private Fridge getFridge() throws Exception {
        Field fridgeField = FridgeBuddy.class.getDeclaredField("myFridge");

        fridgeField.setAccessible(true);

        return (Fridge)fridgeField.get(buddy);
    }
}
