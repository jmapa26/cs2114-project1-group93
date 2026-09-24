import java.time.LocalDate;
import static org.junit.Assert.assertArrayEquals;
/**
 * Tests all the methods in class Fridge
 * 
 * @author Katie Smith (ksmith08)
 * @version Sep 24, 2026
 */
public class FridgeTest
    extends student.TestCase
{
    private Fridge fridge1;
    private Fridge fridge2;

    public void setUp()
    {
        fridge1 = new Fridge();
        fridge2 = new Fridge(5);

        Food apple = new Food("Apple", LocalDate.of(2026, 10, 31));
        Food sandwich = new Food("Sandwich", LocalDate.of(2026, 10, 31));
        Food milk = new Food("Milk", LocalDate.of(2026, 10, 31));

        fridge1.add(apple);
        fridge1.add(sandwich);
        fridge1.add(milk);

        Food tomato = new Food("Tomato", LocalDate.of(2026, 10, 31));
        Food butter = new Food("Butter", LocalDate.of(2026, 10, 31));

        fridge2.add(apple);
        fridge2.add(sandwich);
        fridge2.add(milk);
        fridge2.add(tomato);
        fridge2.add(butter);
    }


    /**
     * tests add()
     */
    public void testAdd()
    {
        Food juice = new Food("Juice", LocalDate.of(2026, 10, 31));
        assertTrue(fridge1.add(juice));
        assertEquals(4, fridge1.getCurrentSize());

        assertFalse(fridge2.add(juice));
    }


    /**
     * tests remove()
     */
    public void testRemove()
    {
        Fridge empty = new Fridge();
        Food apple = new Food("Apple", LocalDate.of(2026, 10, 31));
        Food sandwich = new Food("Sandwich", LocalDate.of(2026, 10, 31));
        assertFalse(empty.remove(apple));
        
        fridge1.add(sandwich);

        assertTrue(fridge1.remove(sandwich));
        
        Food cantaloupe = new Food("Cantaloupe", LocalDate.of(2026, 10, 31));
        assertFalse(fridge1.remove(cantaloupe));
    }


    /**
     * tests clear()
     */
    public void testClear()
    {
        fridge1.clear();
        assertEquals(0, fridge1.getCurrentSize());

    }


    /**
     * tests contains()
     */
    public void testContains()
    {
        assertTrue(fridge2.contains("Tomato"));
        assertFalse(fridge2.contains("Mustard"));
    }


    /**
     * tests isEmpty()
     */
    public void testIsEmpty()
    {
        Fridge empty = new Fridge();
        assertTrue(empty.isEmpty());
        assertFalse(fridge1.isEmpty());
    }


    /**
     * tests getFrequency()
     */
    public void testGetFrequency()
    {
//        Food apple = new Food("Apple", LocalDate.of(2026, 10, 31));
//        fridge1.add(apple);
        assertEquals(1, fridge1.getFrequency("Apple"));

//        Food sandwich = new Food("Sandwich", LocalDate.of(2026, 10, 31));
//        fridge2.add(sandwich);
//        fridge2.add(sandwich);
//
//        assertEquals(3, fridge2.getFrequency("Sandwich"));
    }


    /**
     * tests getCurrentSize()
     */
    public void testGetCurrentSize()
    {
        assertEquals(3, fridge1.getCurrentSize());
    }


    
    
    /**
     * tests getExpiredFood()
     */
    public void testGetExpiredFood()
    {
        Fridge fridge3 = new Fridge();
        
        Food apple = new Food("Apple", LocalDate.of(2026, 10, 31));
        Food sandwich = new Food("Sandwich", LocalDate.of(2025, 1, 3));
        Food milk = new Food("Milk", LocalDate.of(2025, 6, 17));
        
        fridge3.add(apple);
        fridge3.add(sandwich);
        fridge3.add(milk);
        
        Food[] arr = {sandwich, milk};
        
        assertArrayEquals(arr, fridge3.getExpiredFood());
    }
    
    
    
    /**
     * tests toString()
     */
    public void testToString()
    {
        String fridge1String = "[Apple, Sandwich, Milk]";
        assertEquals(fridge1String, fridge1.toString());

        Fridge empty = new Fridge();
        assertEquals("[]", empty.toString());
    }


    /**
     * tests toArray()
     */
    public void testToArray()
    {
        Fridge fridge4 = new Fridge();
        
        Food apple = new Food("Apple", LocalDate.of(2026, 10, 31));
        Food sandwich = new Food("Sandwich", LocalDate.of(2026, 10, 31));
        Food milk = new Food("Milk", LocalDate.of(2026, 10, 31));
        
        fridge4.add(apple);
        fridge4.add(sandwich);
        fridge4.add(milk);

        Food[] arr = {apple, sandwich, milk};
        assertArrayEquals(arr, fridge4.toArray());
    }

}
