import java.time.LocalDate;
import student.TestCase;

/**
 * Tests the Food class.
 *
 * @author Zhaojin Gao
 * @version 09.24.2026
 */
public class FoodTest extends TestCase {
    private Food freshApple;
    private Food spoiledApple;
    private LocalDate today;

    /**
     * Creates food objects before each test.
     */
    public void setUp() {
        today = LocalDate.now();

        freshApple = new Food(
            "Apple", today.plusDays(1), "A bright red apple");

        spoiledApple = new Food(
            "Apple", today.minusDays(1), "A bright red apple");
    }

    /**
     * Tests both constructors.
     */
    public void testConstructor() {
        assertEquals("Apple", freshApple.getName());
        assertEquals(today.plusDays(1),
            freshApple.getExpirationDate());
        assertEquals("A bright red apple",
            freshApple.getDescription());

        Food food = new Food("Milk", today);
        assertEquals("Milk", food.getName());
        assertEquals(today, food.getExpirationDate());
        assertEquals("Missing description", food.getDescription());
    }

    /**
     * Tests expiration before, after, and on today.
     */
    public void testIsExpired() {
        assertFalse(freshApple.isExpired());
        assertTrue(spoiledApple.isExpired());

        Food food = new Food("Milk", today);
        assertFalse(food.isExpired());
    }

    /**
     * Tests the number of days left.
     */
    public void testGetTimeLeft() {
        assertEquals(1, freshApple.getTimeLeft());
        assertEquals(0, spoiledApple.getTimeLeft());

        Food food = new Food("Milk", today);
        assertEquals(0, food.getTimeLeft());

        Food rice = new Food("Rice", today.plusDays(40));
        assertEquals(40, rice.getTimeLeft());
    }

    /**
     * Tests normal and empty names.
     */
    public void testGetName() {
        assertEquals("Apple", freshApple.getName());

        Food food = new Food("", today);
        assertEquals("Unknown food", food.getName());
    }

    /**
     * Tests changing the name.
     */
    public void testSetName() {
        freshApple.setName("Banana");
        assertEquals("Banana", freshApple.getName());

        freshApple.setName("");
        assertEquals("Unknown food", freshApple.getName());

        freshApple.setName("   ");
        assertEquals("Unknown food", freshApple.getName());
    }

    /**
     * Tests rejecting a null name without changing the old name.
     */
    public void testSetNameNull() {
        try {
            freshApple.setName(null);
            fail("A null name should be rejected.");
        }
        catch (IllegalArgumentException exception) {
            assertEquals("Apple", freshApple.getName());
        }
    }

    /**
     * Tests stored expiration dates.
     */
    public void testGetExpirationDate() {
        assertEquals(today.plusDays(1),
            freshApple.getExpirationDate());
        assertEquals(today.minusDays(1),
            spoiledApple.getExpirationDate());
    }

    /**
     * Tests changing the expiration date.
     */
    public void testSetExpirationDate() {
        freshApple.setExpirationDate(today.plusDays(5));
        assertEquals(today.plusDays(5),
            freshApple.getExpirationDate());
        assertEquals(5, freshApple.getTimeLeft());

        freshApple.setExpirationDate(today.minusDays(1));
        assertTrue(freshApple.isExpired());
        assertEquals(0, freshApple.getTimeLeft());
    }

    /**
     * Tests rejecting a null date without changing the old date.
     */
    public void testSetExpirationDateNull() {
        try {
            freshApple.setExpirationDate(null);
            fail("A null date should be rejected.");
        }
        catch (IllegalArgumentException exception) {
            assertEquals(today.plusDays(1),
                freshApple.getExpirationDate());
        }
    }

    /**
     * Tests supplied and default descriptions.
     */
    public void testGetDescription() {
        assertEquals("A bright red apple",
            freshApple.getDescription());

        Food food = new Food("Apple", today);
        assertEquals("Missing description", food.getDescription());
    }

    /**
     * Tests changing the description and handling missing values.
     */
    public void testSetDescription() {
        freshApple.setDescription("A green apple");
        assertEquals("A green apple", freshApple.getDescription());

        freshApple.setDescription("");
        assertEquals("Missing description",
            freshApple.getDescription());

        freshApple.setDescription("   ");
        assertEquals("Missing description",
            freshApple.getDescription());

        freshApple.setDescription(null);
        assertEquals("Missing description",
            freshApple.getDescription());
    }

    /**
     * Tests a null name in the two-argument constructor.
     */
    public void testConstructorNullName() {
        try {
            new Food(null, today);
            fail("A null name should be rejected.");
        }
        catch (IllegalArgumentException exception) {
            assertEquals("Name cannot be null.",
                exception.getMessage());
        }
    }

    /**
     * Tests a null date in the two-argument constructor.
     */
    public void testConstructorNullDate() {
        try {
            new Food("Apple", null);
            fail("A null date should be rejected.");
        }
        catch (IllegalArgumentException exception) {
            assertEquals("Date cannot be null.",
                exception.getMessage());
        }
    }

    /**
     * Tests a null name in the three-argument constructor.
     */
    public void testConstructorNullNameWithDescription() {
        try {
            new Food(null, today, "A red apple");
            fail("A null name should be rejected.");
        }
        catch (IllegalArgumentException exception) {
            assertEquals("Name cannot be null.",
                exception.getMessage());
        }
    }

    /**
     * Tests a null date in the three-argument constructor.
     */
    public void testConstructorNullDateWithDescription() {
        try {
            new Food("Apple", null, "A red apple");
            fail("A null date should be rejected.");
        }
        catch (IllegalArgumentException exception) {
            assertEquals("Date cannot be null.",
                exception.getMessage());
        }
    }
}