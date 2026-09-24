/**
 * Tests all the methods in class Fridge
 * 
 * @author Katie Smith (ksmith08)
 * @version Sep 24, 2026
 */
public class FridgeTest extends student.TestCase
{
    private Fridge fridge1;
    private Fridge fridge2;
    
    public void setUp()
    {
        fridge1 = new Fridge();
        fridge2 = new Fridge(5);
        
        Food apple = new Food("Apple", today.plusDays(2));
        Food sandwich = new Food("Sandwich", today.plusDays(3));
        Food milk = new Food("Milk", today.plusDays(1));
        
        fridge1.add(apple);
        fridge2.add(sandwich);
        fridge1.add(milk);
        
        Food tomato = new Food("Tomato", today.plusDays(3));
        Food butter = new Food("Butter", today.plusDays(1));
        
        fridge1.add(apple);
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
        Food juice = new Food("Juice", today.plusDays(2));
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
        assertNull(empty.remove(apple));
        
        assertEquals(sandwich, fridge1.remove(sandwich));
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
        assertEquals(1, fridge2.getFrequency("Apple"));
        
        Food sandwich = new Food("Sandwich", today.plusDays(3));
        fridge2.add(sandwich);
        fridge2.add(sandwich);
        
        assertEquals(3, fridge1.getFrequency("Sandwich"));
    }
    
    
    /**
     * tests getCurrentSize()
     */
    public void testGetCurrentSize()
    {
        assertEquals(3, fridge1.getCurrentSize());
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
        Food apple = new Food("Apple", today.plusDays(2));
        Food sandwich = new Food("Sandwich", today.plusDays(3));
        Food milk = new Food("Milk", today.plusDays(1));
        
        Food[] arr = {apple, sandwich, milk};
        assertEquals(arr, fridge1.toArray());
    }

}
