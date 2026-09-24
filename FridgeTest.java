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
        
        fridge1.addFood(apple);
        fridge2.addFood(sandwich);
        fridge1.addFood(milk);
        
        Food tomato = new Food("Tomato", today.plusDays(3));
        Food butter = new Food("Butter", today.plusDays(1));
        
        fridge1.addFood(apple);
        fridge2.addFood(sandwich);
        fridge2.addFood(milk);
        fridge2.addFood(tomato);
        fridge2.addFood(butter);
    }
    
    
    /**
     * tests add()
     */
    public void testAdd()
    {
        Food juice = new Food("Juice", today.plusDays(2));
        assertTrue(fridge1.add(juice));
        
        assertFalse(fridge2.add(juice));
    }

}
