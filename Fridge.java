// import statements here

// -----------------------------------------------------------------------------
/**
 * Stores information about a Fridge (bag) and the food objects insaide of it
 * 
 * @author Katie Smith (ksmith08)
 * @version Sep 24, 2026
 */

public class Fridge implements Bag<Food>
{

    // ~ Fields ................................................................
    private Food[] food;
    private int size;
    private int capacity;

    private static final int DEFAULT_SIZE = 10;

    // ~ Constructor ...........................................................
    /**
     * Constructor, creates a Fridge object
     */
    public Fridge() 
    {
        this(DEFAULT_SIZE);
    }
    
    /**
     * Constructor, creates a Fridge object
     * 
     * @param  capacity number of items that the bag can hold
     */
    @SuppressWarnings("unckecked")
    public Fridge(int capacity)
    {
        this.food = (Food[]) new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }

    // ~ Public Methods ........................................................

    /*
     * Please add javadoc comments for all your methods,
     * even if they are self-explanatory!
     *
     * For javadoc comments, you can use the following tags
     * 
     * @param parameter
     * Include parameter explanation
     * 
     * @return return value, and explanation if necessary
     * 
     * @throws exceptionName
     * if the method throws an exception
     */

    /**
     * Adds a food item to the Fridge
     * 
     * @param  newFood the new food item to be added
     * 
     * @return boolean whether or not the food was successfully added
     */
    public boolean add(Food newFood) 
    {
        if(size >= capacity)
        {
            return false;
        }
        food[size] = newFood;
        size++;
        return true;
    }
    
    
    /**
     * removess a speciic food item from the Fridge
     * 
     * @param  toBeRemoved the food item to be removed
     * 
     * @return Food the food item that was removed from the Fridge
     */
    public Food remove(Food toBeRemoved)
    {
        if(size == 0)
        {
            return null;
        }
        for(int i = 0; i < size; i++)
        {
            if(food[i].equals(toBeRemoved))
            {
                food[i] = null;
                size--;
                return toBeRemoved;
            }
        }
        return toBeRemoved;
    }
    
    
    /**
     * Clears every item out of the Fridge
     */
    public void clear()
    {
        for(int i = 0; i < size; i++)
        {
            food[i] = null;
        }
    }
    
    /**
     * Checks if the Fridge contains the inputted Food item
     * 
     * @param  String name of the food that is being searched for
     * 
     * @return boolean whether or not the Fridge contains that Food
     */
    public boolean contains(String anEntry)
    {
        for(int i = 0; i < size; i++)
        {
            if(food[i].getName().equals(anEntry))
            {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Checks if the Fridge is empty
     * 
     * @return boolean whether or not the Fridge is empty
     */
    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }
        return false;
    }
    
    
    /**
     * checks the number of times a certain food is in the Fridge
     * 
     * @param  String the name of the Food that is being counted
     * 
     * @return int the number of times that Food is in the Fridge
     */
    public int getFrequency(String anEntry)
    {
        int count = 0;
        for(int i = 0; i < size; i++)
        {
            if(food[i].getName().equals(anEntry))
            {
                count++;
            }
        }
        return count;
    }
    
    
    /**
     * returns the number of items currently in the Fridge
     * 
     * @return int the size of the Fridge
     */
    public int getCurrentSize()
    {
        return size;
    }
    
    
    /**
     * Turns the Foods in the Fridge into one string
     * 
     * @return String all of the Food items put together
     */
    public String toString()
    {
        if(size == 0)
        {
            return "[]";
        }
        
        String foodString = "[";
        for(int i = 0; i < size - 1; i++)
        {
            foodString += food[i] + ", ";
        }
        foodString += food[size - 1] + "]";
        return foodString;
    }
    
    
    /**
     * Turns the Foods in the Fridge into an array
     * 
     * @return Food[] all of the food items in an array
     */
    public Food[] toArray()
    {
        Food[] foodArr = new Food[size];
        for(int i = 0; i < size; i++)
        {
            foodArr[i] = food[i];
        }
        return foodArr;
    }
    
    
    
    
}

